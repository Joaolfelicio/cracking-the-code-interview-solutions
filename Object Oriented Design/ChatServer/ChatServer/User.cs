using System;
using System.Collections.Generic;
using System.Text;

namespace ChatServer
{
    public class User
    {
        public User(UserManager userManager, string name)
        {
            Id = new Guid();
            UserManager = userManager;
            Name = Name;
        }

        public Guid Id { get; set; }
        public string Name { get; set; }
        public string Status { get; set; }
        public bool IsOnline { get; set; } = true;
        public UserManager UserManager { get; set; }
        public Dictionary<Guid, User> Friends { get; set; }
        public Dictionary<Guid, User> FriendsRequestReceived { get; set; }
        public Dictionary<Guid, User> FriendsRequestSent { get; set; }
        public Dictionary<Guid, Conversation> Conversations { get; set; }

        public bool SendFriendRequest(User user)
        {
            if (HasSentFriendRequest(user) || IsFriend(user)) return false;

            if (HasReceivedFriendRequest(user))
            {
                return AcceptFriendRequest(user);
            }

            FriendsRequestSent.Add(user.Id, user);
            user.FriendsRequestReceived.Add(Id, this);
            return true;
        }
        public bool AcceptFriendRequest(User user)
        {
            if (!HasReceivedFriendRequest(user)) return false;

            FriendsRequestReceived.Remove(user.Id);
            Friends.Add(user.Id, user);
            user.FriendsRequestSent.Remove(Id);
            user.Friends.Add(user.Id, user);
            return true;
        }
        public bool RemoveFriend(User user)
        {
            if (!IsFriend(user)) return false;

            Friends.Remove(user.Id);
            user.Friends.Remove(user.Id);
            return true;
        }
        public bool HasSentFriendRequest(User user) => FriendsRequestSent.ContainsKey(user.Id);
        public bool HasReceivedFriendRequest(User user) => FriendsRequestReceived.ContainsKey(user.Id);
        public bool IsFriend(User user) => Friends.ContainsKey(user.Id);

        public void LogIn()
        {
            var successLogIn = UserManager.UserWentOnline(this);
            if (successLogIn) IsOnline = true;
        }
        public void LogOff()
        {
            var successLogOff = UserManager.UserWentOffline(this);
            if (successLogOff) IsOnline = false;
        }

        public void ChangeStatus(string message) => Status = message;
    }
}
