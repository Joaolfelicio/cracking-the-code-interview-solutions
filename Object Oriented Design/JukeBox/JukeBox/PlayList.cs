using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class PlayList : PlayItem
    {
        public void AddSong(Song song) => Songs.Enqueue(song);
    }
}
