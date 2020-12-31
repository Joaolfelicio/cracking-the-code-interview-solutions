using System;
using System.Collections.Generic;

namespace ChatServer
{
    public class GroupChat : Conversation
    {
        public GroupChat() : base()
        {
        }

        public Dictionary<Guid, User> Users { get; private set; }
        
        public bool IsUserInChat(User user) => Users.ContainsKey(user.Id);
        public bool AddUserToChat(User user)
        {
            if (IsUserInChat(user)) return false;

            Users.Add(user.Id, user);
            return true;
        }
        public bool RemoveUserFromChat(User user)
        {
            if (!IsUserInChat(user)) return false;

            Users.Remove(user.Id);
            return true;
        }

        public override bool SendMessage(string text, User user)
        {
            if (!IsUserInChat(user)) return false;

            var message = new Message(text, user);
            Messages.Add(message.Id, message);
            return true;
        }

        public override bool DeleteMessage(Message message)
        {
            if (Messages.ContainsKey(message.Id)) return false;

            Messages.Remove(message.Id);
            return true;
        }
    }
}