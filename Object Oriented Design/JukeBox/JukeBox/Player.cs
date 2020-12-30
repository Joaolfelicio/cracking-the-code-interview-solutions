using System;
using System.Collections.Generic;
using System.Text;

namespace JukeBox
{
    public class Player
    {
        public PlayItem PlayItem { get; private set; }

        public bool IsPlaying() => PlayItem != null;

        public void StopPlaying()
        {
            if (IsPlaying()) PlayItem = null;
        }

        public void Play(PlayItem playItem)
        {
            StopPlaying();
            PlayItem = playItem;
            PlayItem.Play();
        }
    }
}
