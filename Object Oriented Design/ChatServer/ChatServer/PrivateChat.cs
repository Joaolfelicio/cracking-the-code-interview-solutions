namespace ChatServer
{
    public class PrivateChat : Conversation
    {
        public PrivateChat() : base()
        {
        }

        public User User { get; private set; }
    }
}