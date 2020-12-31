using System;
using System.Collections.Generic;

namespace BookReader
{
    public class UserManager
    {
        public Dictionary<Guid, User> Users { get; set; }

        public bool AddUser(User user)
        {
            if (Users.ContainsKey(user.Id)) return false;

            Users.Add(user.Id, user);
            return true;
        }

        public bool RemoveUser(Guid id)
        {
            if (!Users.ContainsKey(id)) return false;

            Users.Remove(id);
            return true;
        }

        public User GetUser(Guid id)
        {
            if (!Users.ContainsKey(id)) return null;

            return Users[id];
        }
    }
}