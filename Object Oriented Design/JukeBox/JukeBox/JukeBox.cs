using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class JukeBox
    {
        public JukeBox()
        {
            Player = new Player();
        }

        public List<Cd> Cds { get; set; }
        public List<PlayList> PlayLists { get; set; }
        public Player Player { get; private set; }
        public User User { get; private set; }

        public void Play(PlayItem playItem) => Player.Play(playItem);
        public Song GetCurrentSong() => Player.PlayItem.GetCurrentSong();
        public void ChangeUser(User user)
        {
            Player.StopPlaying();
            User = user;
        }
    }
}
