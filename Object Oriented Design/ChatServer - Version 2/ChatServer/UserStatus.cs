using System;
using System.Collections.Generic;
using System.Text;

namespace ChatServer
{
    public class UserStatus
    {
        public UserStatus(string message, UserStatusType userStatusType)
        {
            Message = message;
            UserStatusType = userStatusType;
        }
        public UserStatus(UserStatusType userStatusType)
        {
            UserStatusType = userStatusType;
        }

        public string Message { get; }
        public UserStatusType UserStatusType { get; }
    }
}
