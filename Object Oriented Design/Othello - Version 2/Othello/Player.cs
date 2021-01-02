using System.Reflection.Metadata.Ecma335;

namespace Othello
{
    public class Player
    {
        public Player(Color color)
        {
            Color = color;
        }

        public Color Color { get; }

        public int GetScore() => Game.GetInstance().Board.GetScoreForColor(Color);

        public bool PlayPiece(int row, int column) => Game.GetInstance().Board.PlaceColor(row, column, Color);
    }
}