using System;
using System.Collections.Generic;
using System.Text;

namespace DeckOfCards
{
    public class Hand<T> where T : Card
    {
        public IList<T> Cards { get; set; }

        public int Score()
        {
            var score = 0;

            foreach (var card in Cards)
            {
                score += card.Value();
            }

            return score;
        }

        public void AddCard(T card)
        {
            Cards.Add(card);
        }
    }
}
