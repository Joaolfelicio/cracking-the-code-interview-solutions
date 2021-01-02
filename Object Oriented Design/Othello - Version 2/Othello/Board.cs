namespace Othello
{
    public class Board
    {
        public Board(int rows, int columns)
        {
            BoardPieces = new Piece[rows, columns];
        }

        public int BlackCount { get; private set; } = 0;
        public int WhiteCount { get; private set; } = 0;
        public Piece[,] BoardPieces { get; private set; }

        public bool HasPiece(int row, int col) => BoardPieces[row, col] != null;

        public void Initialize()
        {
            var middleRow = BoardPieces.GetLength(0) / 2;
            var middleCol = BoardPieces.GetLength(1) / 2;

            BoardPieces[middleRow, middleCol] = new Piece(Color.White);
            BoardPieces[middleRow + 1, middleCol] = new Piece(Color.Black);
            BoardPieces[middleRow + 1, middleCol + 1] = new Piece(Color.White);
            BoardPieces[middleRow, middleCol + 1] = new Piece(Color.Black);

            BlackCount = 2;
            WhiteCount = 2;
        }

        public bool PlaceColor(int row, int col, Color color)
        {
            if (HasPiece(row, col)) return false;

            // Try to flip each of the four directions
            var results = new int[4];
            results[0] = FlipSection(row - 1, col, color, Direction.Top);
            results[1] = FlipSection(row + 1, col, color, Direction.Down);
            results[2] = FlipSection(row, col + 1, color, Direction.Right);
            results[3] = FlipSection(row, col - 1, color, Direction.Left);

            // How many pieces were flipped

            int flipped = 0;

            foreach (var result in results)
            {
                if (result > 0) flipped += result;
            }

            // If nothing was flipped, then it's an invalid move
            if (flipped < 0) return false;

            // Flip the piece and update the score
            BoardPieces[row, col] = new Piece(color);
            UpdateScore(color, flipped + 1);
            return true;
        }

        private int FlipSection(int row, int col, Color color, Direction direction)
        {
            // Compute the delta for the row and the column. At all times, only the row or the column
            // will have a delta, since we're only moving in one direction at a time.

            var vertically = 0;
            var horizontally = 0;

            switch (direction)
            {
                case Direction.Top:
                    vertically = -1;
                    break;
                case Direction.Down:
                    vertically = 1;
                    break;
                case Direction.Left:
                    horizontally = -1;
                    break;
                case Direction.Right:
                    horizontally = 1;
                    break;
            }

            // If out of bounds, or nothing to flip, return -1;
            if (row < 0 || row >= BoardPieces.GetLength(0) || 
                col < 0 || col >= BoardPieces.GetLength(1) ||
                !HasPiece(row, col))
            {
                return -1;
            }

            // Found same color, return 0
            if (BoardPieces[row, col].Color == color) return 0;

            // Recursively flip the remainder of the row. If -1 is returned, then we know we hit the boundary
            // of the row (or a null piece) before we found our own color, so there's nothing to flip. Return
            // the error code.

            var flipped = FlipSection(row + vertically, col + horizontally, color, direction);

            if (flipped < 0) return -1;

            BoardPieces[row, col].Flip();

            return flipped + 1;
        }

        public int GetScoreForColor(Color color)
        {
            if (color == Color.Black) return BlackCount;
            return WhiteCount;
        }

        public void UpdateScore(Color color, int newPieces)
        {
            // If we added x pieces of a color, then we actually removed x - 1 pieces of the opposite color

            if (color == Color.Black)
            {
                WhiteCount -= newPieces - 1;
                BlackCount += newPieces;
            }
            else
            {
                WhiteCount += newPieces;
                BlackCount -= newPieces - 1;
            }
        }
    }
}