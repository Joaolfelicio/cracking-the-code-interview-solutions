namespace DeckOfCards
{
    public abstract class Card
    {
        protected Card(int faceValue, Suit suit)
        {
            FaceValue = faceValue;
            Suit = suit;
        }

        public int FaceValue { get; set; }
        public Suit Suit { get; set; }
        public bool IsAvailable { get; set; }
        public abstract int Value();
    }
}