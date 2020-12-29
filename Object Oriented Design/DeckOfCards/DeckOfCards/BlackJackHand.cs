using System;
using System.Collections.Generic;
using System.Text;

namespace DeckOfCards
{
    public class BlackJackHand : Hand<BlackJackCard>
    {
        public bool HasBusted => Score() > 21;
        public bool Is21 => Score() == 21;

        public bool IsBlackJack
        {
            get
            {
                if (Cards.Count != 2) return false;

                return Is21;
            }
        }

        public new int Score()
        {
            var maxUnder = Int32.MinValue;
            var minOver = Int32.MaxValue;

            foreach (var score in PossibleScores())
            {
                if (score == 21)
                {
                    return score;
                }
                
                if (score < 21)
                {
                    maxUnder = Math.Max(score, maxUnder);
                }
                else
                {
                    minOver = Math.Min(score, minOver);
                }
            }

            return maxUnder == Int32.MinValue ? minOver : maxUnder;
        }

        private IList<int> PossibleScores()
        {
            var scores = new List<int>();

            if (Cards.Count == 0) return scores;

            foreach (var card in Cards)
            {
                AddCardToScoreList(card, scores);
            }

            return scores;
        }

        private void AddCardToScoreList(BlackJackCard card, IList<int> scores)
        {
            if (scores.Count == 0)
            {
                scores.Add(0);
            }

            var scoresLength = scores.Count;

            for (var i = 0; i < scoresLength; i++)
            {
                var score = scores[i];

                scores[i] = score + card.MinValue();

                if (card.MinValue() != card.MaxValue())
                {
                    scores.Add(score + card.MaxValue());
                }
            }
        }
    }
}
