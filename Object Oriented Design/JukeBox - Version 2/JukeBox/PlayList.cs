using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class PlayList
    {
        public Cd Cd { get; set; }
        public Song CurrentSong { get; private set; }
        public Queue<Song> Songs { get; private set; }

        public void SkipSong() => CurrentSong = Songs.Dequeue();
        public void AddSong(Song song) => Songs.Enqueue(song);
        public Song ShowNextSong() => Songs.Peek();
    }
}
