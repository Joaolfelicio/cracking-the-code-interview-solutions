namespace Othello
{
    public class Game
    {
        private Player[] Players { get; set; }
        private static Game Instance { get; set; }
        public Board Board { get; private set; }
        private const int Rows = 10;
        private const int Columns = 10;

        private Game()
        {
            Board = new Board(Rows, Columns);
            Players = new Player[2];
            Players[0] = new Player(Color.Black);
            Players[1] = new Player(Color.White);
        }

        public static Game GetInstance()
        {
            if (Instance == null) Instance = new Game();
            return Instance;
        }
    }
}