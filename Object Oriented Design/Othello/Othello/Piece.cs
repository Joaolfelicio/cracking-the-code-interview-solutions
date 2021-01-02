using System.Collections.Generic;
using System.Data;

namespace Othello
{
    public class Piece
    {
        public Piece(Color color, Position position)
        {
            Color = color;
            Position = position;
            SurroundingPieces = new Piece[3, 3];
            SurroundingPieces[1,1] = this;
        }

        public Position Position { get; private set; }
        public Color Color { get; private set; }
        public Piece[,] SurroundingPieces { get; private set; }

        private void FlipPiece() => Color = Color == Color.Black ? Color.White : Color.Black;
        private bool IsSurrounded() => IsSurroundedVertically() || IsSurroundedHorizontally() || IsSurroundedDiagonally();
        public bool IsOppositeColor(Color color) => color != Color;
        public void AddSurroundingPiece(Piece piece)
        {
            var row = piece.Position.Row >= 2 ? piece.Position.Row - 2 : piece.Position.Row;
            var column = piece.Position.Column >= 2 ? piece.Position.Column - 2 : piece.Position.Row;

            if(!HasAdjacentPiece(row, column)) SurroundingPieces[row, column] = piece;

            if (IsSurroundedHorizontally() || IsSurroundedVertically() || IsSurroundedDiagonally()) FlipPiece();
        }

        private bool HasAdjacentPiece(int row, int column)
        {
            if (row >= 3 || column >= 3) return false;

            return SurroundingPieces[row, column] != null;
        }

        private bool IsSurroundedHorizontally()
        {
            return HasAdjacentPiece(1, 0) && SurroundingPieces[1, 0].IsOppositeColor(Color) && 
                   HasAdjacentPiece(1, 2) && SurroundingPieces[1, 2].IsOppositeColor(Color);
        }

        private bool IsSurroundedVertically()
        {
            return HasAdjacentPiece(0, 1) && SurroundingPieces[0, 1].IsOppositeColor(Color) &&
                   HasAdjacentPiece(2, 1) && SurroundingPieces[2, 1].IsOppositeColor(Color);
        }

        private bool IsSurroundedDiagonally()
        {
            var isSurroundedTopToBot = HasAdjacentPiece(0, 0) && SurroundingPieces[0, 0].IsOppositeColor(Color) &&
                                       HasAdjacentPiece(2, 2) && SurroundingPieces[2, 2].IsOppositeColor(Color);

            var isSurroundedBotToTop = HasAdjacentPiece(2, 0) && SurroundingPieces[2, 0].IsOppositeColor(Color) &&
                                       HasAdjacentPiece(0, 2) && SurroundingPieces[0, 2].IsOppositeColor(Color);

            return isSurroundedTopToBot || isSurroundedBotToTop;
        }
    }
}