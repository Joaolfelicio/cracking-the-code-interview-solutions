using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class Player
    {
        public Cd Cd { get; private set; }
        public PlayStatus PlayStatus { get; private set; }

        public Song GetCurrentSong() => Cd.PlayList.CurrentSong;
        public bool IsPlaying() => PlayStatus == PlayStatus.Playing;
        public Cd GetPlayingCd() => Cd;
        
        public void StopPlaying()
        {
            if (IsPlaying()) PlayStatus = PlayStatus.Paused;
        }

        public void Play(Cd cd)
        {
            RemoveCd();
            Cd = cd;
            PlayStatus = PlayStatus.Playing;
        }

        private void RemoveCd()
        {
            StopPlaying();
            if(Cd != null) Cd = null;
        }
    }
}
