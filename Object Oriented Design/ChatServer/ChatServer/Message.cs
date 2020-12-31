using System;

namespace ChatServer
{
    public class Message
    {
        public Message(string text, User sentBy)
        {
            Id = Guid.NewGuid();
            Text = text;
            SentBy = sentBy;
            SentTime = DateTime.Now;
        }

        public Guid Id { get; }
        public string Text { get; set; }
        public User SentBy { get; set; }
        public DateTime SentTime { get; set; }
    }
}