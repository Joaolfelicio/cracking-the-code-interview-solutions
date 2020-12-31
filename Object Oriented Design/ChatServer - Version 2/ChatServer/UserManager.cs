using System;
using System.Collections.Generic;
using System.Text;

namespace ChatServer
{
    public sealed class UserManager
    {
        private static UserManager _instance;
        public static UserManager Instance {

            get {
                if (_instance == null) _instance = new UserManager();
                return _instance;
            }
        }

        public Dictionary<int, User> UsersById { get; } = new Dictionary<int, User>();
        public Dictionary<string, User> UsersByAccountName { get; } = new Dictionary<string, User>();
        public Dictionary<int, User> OnlineUsers { get; } = new Dictionary<int, User>();

        public void AddUser(User fromUser, string toAccountName)
        {
            var toUser = UsersByAccountName[toAccountName];
            var request = new AddRequest(fromUser, toUser);

            toUser.ReceivedAddRequest(request);
            fromUser.SentAddRequest(request);
        }

        public void ApprovedAddRequest(AddRequest request)
        {
            request.RequestStatus = RequestStatus.Accepted;

            var fromUser = request.FromUser;
            var toUser = request.ToUser;

            fromUser.AddContact(toUser);
            toUser.AddContact(fromUser);
        }

        public void RejectAddRequest(AddRequest request)
        {
            request.RequestStatus = RequestStatus.Rejected;

            var fromUser = request.FromUser;
            var toUser = request.ToUser;

            fromUser.RemoveAddRequest(request);
            toUser.RemoveAddRequest(request);
        }

        public void UserSignedOn(string accountName)
        {
            if (!UsersByAccountName.ContainsKey(accountName)) return;

            var user = UsersByAccountName[accountName];
            user.UserStatus = new UserStatus(UserStatusType.Available);
            OnlineUsers.Add(user.Id, user);
        }

        public void UserSignedOff(string accountName)
        {
            if (!UsersByAccountName.ContainsKey(accountName)) return;

            var user = UsersByAccountName[accountName];
            user.UserStatus = new UserStatus(UserStatusType.Offline);
            OnlineUsers.Remove(user.Id);
        }
    }
}
