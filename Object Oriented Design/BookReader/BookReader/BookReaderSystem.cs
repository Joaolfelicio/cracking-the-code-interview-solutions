using System.Collections.Generic;

namespace BookReader
{
    public class BookReaderSystem
    {
        public BookReaderSystem()
        {
            BookStore = new BookStore();
        }

        public List<User> User { get; private set; }
        public BookStore BookStore { get; }
    }
}