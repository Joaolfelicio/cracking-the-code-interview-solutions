using System.Collections.Generic;

namespace ChatServer
{
    public abstract class Conversation
    {
        public int Id { get; }
        protected List<User> Participants { get; } = new List<User>();
        protected List<Message> Messages { get; } = new List<Message>();

        public void SendMessage(Message message) => Messages.Add(message);
    }
}