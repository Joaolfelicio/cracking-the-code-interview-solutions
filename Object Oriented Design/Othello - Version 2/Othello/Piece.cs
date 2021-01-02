namespace Othello
{
    public class Piece
    {

        public Piece(Color color)
        {
            Color = color;
        }

        public Color Color { get; private set; }

        public void Flip()
        {
            if (Color == Color.Black) Color = Color.White;
            else Color = Color.Black;
        }
    }
}