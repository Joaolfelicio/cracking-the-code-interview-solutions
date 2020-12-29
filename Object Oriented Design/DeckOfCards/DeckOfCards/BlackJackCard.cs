using System;
using System.Collections.Generic;
using System.Text;

namespace DeckOfCards
{
    public class BlackJackCard : Card
    {
        public bool IsFaceCard => FaceValue > 10 && FaceValue < 14;
        public bool IsAce => FaceValue == 1;

        public BlackJackCard(int faceValue, Suit suit) : base(faceValue, suit)
        {
        }

        public override int Value()
        {
            if (IsAce) return 1;
            if (IsFaceCard) return 10;

            return FaceValue;
        }

        public int MaxValue()
        {
            if (IsAce) return 11;
            return Value();
        }

        public int MinValue()
        {
            if (IsAce) return 1;
            return Value();
        }
    }
}
