using System.ComponentModel.DataAnnotations;

namespace Othello
{
    public class Board
    {
        public Board()
        {
            MatrixBoard = new Piece[8,8];
        }

        public void StartGame()
        {
            InsertPiece(Color.White, 3, 3);
            InsertPiece(Color.White, 3, 4);
            InsertPiece(Color.Black, 4, 3);
            InsertPiece(Color.Black, 4, 4);
        }

        public void RestartGame()
        {
            for (int i = 0; i < MatrixBoard.GetLength(0); i++)
            {
                for(int j = 0; j < MatrixBoard.GetLength(1); j++)
                {
                    MatrixBoard[i, j] = null;
                }
            }
            StartGame();
        }

        public Piece[,] MatrixBoard { get; set; }

        public bool InsertPiece(Color color, int row, int col)
        {
            var position = new Position(row, col);

            if (HasPiece(position)) return false;

            var newPiece = new Piece(color, position);

            MatrixBoard[position.Row, position.Column] = newPiece;
            RefreshGrid(newPiece);

            return true;
        }

        private void RefreshGrid(Piece piece)
        {
            var position = piece.Position;

            var rowLength = MatrixBoard.GetLength(0);
            var colLength = MatrixBoard.GetLength(1);

            for (var row = position.Row - 1; row <= position.Row + 1; row++)
            {
                for (var col = position.Column - 1; col <= position.Column + 1; col++)
                {
                    if(row >= 0 && row < rowLength && 
                       col >= 0 && col < colLength && 
                       position.Row != row && position.Column != col &&
                       !HasPiece(new Position(row, col)))
                    {
                        MatrixBoard[row, col].AddSurroundingPiece(piece);
                    }
                }
            }
        }

        private bool HasPiece(Position position) => MatrixBoard[position.Column, position.Row] != null;
    }
}