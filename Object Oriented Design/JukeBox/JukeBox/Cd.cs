using System;
using System.Collections;
using System.Collections.Generic;

namespace JukeBox
{
    public class Cd : PlayItem
    {
        public string ArtistName { get; set; }
        public DateTime ProducedDate { get; set; }
    }
}