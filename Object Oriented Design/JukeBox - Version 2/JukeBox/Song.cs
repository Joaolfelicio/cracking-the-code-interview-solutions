using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace JukeBox
{
    public class Song
    {
        public string Name { get; set; }
        public Stream Content { get; set; }
        public Cd Cd { get; set; }
        public void PlaySong() => Console.WriteLine($"Playing Song {Name}");
    }
}
