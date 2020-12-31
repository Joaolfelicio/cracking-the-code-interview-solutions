using System;
using System.Collections.Generic;

namespace ChatServer
{
    public abstract class Conversation
    {
        public Conversation()
        {
            Id = new Guid();
        }

        public Guid Id { get; }
        public Dictionary<Guid, Message> Messages { get; private set; }
        public bool SendMessage(string text, User user);
        public bool DeleteMessage(Message message);
    }
}