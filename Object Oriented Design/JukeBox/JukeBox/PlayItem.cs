using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public abstract class PlayItem
    {
        public string Name { get; set; }
        public long Id { get; set; }
        public Queue<Song> Songs { get; private set; }
        public Song CurrentSong { get; private set; }
        public Song GetCurrentSong() => CurrentSong;

        public void Play() => CurrentSong.PlaySong();
        public void SkipSong() => CurrentSong = Songs.Dequeue();
        public Song ShowNextSong() => Songs.Peek();
    }
}
