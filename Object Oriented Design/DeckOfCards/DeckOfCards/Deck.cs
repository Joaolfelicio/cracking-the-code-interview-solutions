using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;

namespace DeckOfCards
{
    public class Deck<T> where T : Card
    {
        public IList<T> Cards { get; set; }
        private int DealtIndex = 0;

        public void Shuffle() {}

        public int RemainingCards()
        {
            return Cards.Count - DealtIndex;
        }

        public T DealCard()
        {
            return Cards[DealtIndex++];
        }

        public IList<T> DealHand(int numOfCards)
        {
            var hand = new List<T>();

            for(var i = 0; i < numOfCards; i++)
                hand.Add(DealCard());

            return hand;
        }
    }
}