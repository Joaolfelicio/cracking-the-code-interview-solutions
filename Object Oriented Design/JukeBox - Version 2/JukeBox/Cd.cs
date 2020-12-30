using System;
using System.Collections;
using System.Collections.Generic;

namespace JukeBox
{
    public class Cd
    {
        public string Name { get; set; }
        public PlayList PlayList { get; set; }
        public string ArtistName { get; set; }
        public DateTime ProducedDate { get; set; }
    }
}