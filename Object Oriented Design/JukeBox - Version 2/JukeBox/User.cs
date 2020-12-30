using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class User
    {
        public User(string name, long id)
        {
            Name = name;
            Id = id;
        }

        public string Name { get; set; }
        public long Id { get; set; }
    }
}
