using System;
using System.Collections.Generic;
using System.Reflection.Metadata.Ecma335;
using System.Text;

namespace ChatServer
{
    public class UserManager
    {
        private static UserManager _instance;
        public Dictionary<Guid, User> Users { get; set; }
        public Dictionary<Guid, User> OnlineUsers { get; set; }

        public static UserManager GetInstance()
        {
            if(_instance == null) _instance = new UserManager();
            return _instance;
        }

        public int OnlineUsersCount() => OnlineUsers.Count;
        public bool UserExists(User user) => Users.ContainsKey(user.Id);

        public bool CreateUser(User user)
        {
            if (UserExists(user)) return false;

            Users.Add(user.Id, user);
            OnlineUsers.Add(user.Id, user);

            return true;
        }
        public bool DeleteUser(User user)
        {
            if (!UserExists(user)) return false;
            
            UserWentOffline(user);
            Users.Remove(user.Id);

            return true;
        }

        public bool IsUserOnline(User user) => OnlineUsers.ContainsKey(user.Id);
        public bool UserWentOffline(User user)
        {
            if (!IsUserOnline(user)) return false;
            
            OnlineUsers.Remove(user.Id);

            return true;
        }
        public bool UserWentOnline(User user)
        {
            if (IsUserOnline(user)) return false;

            OnlineUsers.Add(user.Id, user);

            return true;
        }
    }
}
