using System;

namespace ChatServer
{
    public class AddRequest
    {
        public AddRequest(User fromUser, User toUser)
        {
            FromUser = fromUser;
            ToUser = toUser;
            Date = DateTime.Now;
            RequestStatus = RequestStatus.Unread;
        }

        public User FromUser { get; }
        public User ToUser { get; }
        public DateTime Date { get; }
        public RequestStatus RequestStatus { get; set; }
    }
}