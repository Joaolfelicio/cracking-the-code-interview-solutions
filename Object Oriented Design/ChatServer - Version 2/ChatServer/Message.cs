using System;

namespace ChatServer
{
    public class Message
    {
        public Message(string content)
        {
            Content = content;
            Date = DateTime.Now;
        }

        public string Content { get; }
        public DateTime Date { get; }
    }
}