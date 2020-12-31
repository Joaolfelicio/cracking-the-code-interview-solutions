namespace ChatServer
{
    public class GroupChat : Conversation
    {
        public void RemoveParticipant(User user) => Participants.Remove(user);
        public void AddParticipant(User user) => Participants.Add(user);
    }
}