using System.Collections.Generic;

namespace ChatServer
{
    public class User
    {
        public User(int id, string name, string fullName)
        {
            Id = id;
            Name = name;
            FullName = fullName;
        }

        public int Id { get; }
        public UserStatus UserStatus { get; set; } = null;
        public Dictionary<int, PrivateChat> PrivateChats { get; } = new Dictionary<int, PrivateChat>();
        public Dictionary<int, GroupChat> GroupChats { get; } = new Dictionary<int, GroupChat>();
        public Dictionary<int, AddRequest> ReceivedAddRequests { get; } = new Dictionary<int, AddRequest>();
        public Dictionary<int, AddRequest> SentAddRequests { get; } = new Dictionary<int, AddRequest>();
        public Dictionary<int, User> Contacts { get; } = new Dictionary<int, User>();
        public string Name { get; }
        public string FullName { get; }

        public bool SendMessageToUser(User toUser, string content)
        {
            if (!PrivateChats.ContainsKey(toUser.Id)) return false;

            var privateChat = PrivateChats[toUser.Id];
            privateChat.SendMessage(new Message(content));

            return true;
        }

        public bool SendMessageToGroupChat(int groupId, string content)
        {
            if (!GroupChats.ContainsKey(groupId)) return false;

            var group = GroupChats[groupId];
            group.SendMessage(new Message(content));

            return true;
        }

        public bool AddContact(User user)
        {
            if (Contacts.ContainsKey(user.Id)) return false;
            Contacts.Add(user.Id, user);

            return true;
        }

        public void ReceivedAddRequest(AddRequest request)
        {
            if (ReceivedAddRequests.ContainsKey(request.FromUser.Id)) return;
            ReceivedAddRequests.Add(request.FromUser.Id, request);
        }

        public void SentAddRequest(AddRequest request)
        {
            if (SentAddRequests.ContainsKey(request.FromUser.Id)) return;
            SentAddRequests.Add(request.FromUser.Id, request);
        }

        public void RemoveAddRequest(AddRequest request)
        {
            if (request.FromUser == this) SentAddRequests.Remove(request.FromUser.Id);
            else if (request.ToUser == this) ReceivedAddRequests.Remove(request.FromUser.Id);
        }

        public void RequestAddUser(string accountName) => UserManager.Instance.AddUser(this, accountName);

        public void AddConversation(PrivateChat privateChat) => PrivateChats.Add(privateChat.GetOtherParticipant(this).Id, privateChat);

        public void AddConversation(GroupChat groupChat) => GroupChats.Add(groupChat.Id, groupChat);
    }
}