using System.Linq;

namespace ChatServer
{
    public class PrivateChat : Conversation
    {
        public PrivateChat(User userOne, User userTwo)
        {
            Participants.Add(userOne);
            Participants.Add(userTwo);
        }

        public User GetOtherParticipant(User user) => Participants.FirstOrDefault(x => x != user);
    }
}