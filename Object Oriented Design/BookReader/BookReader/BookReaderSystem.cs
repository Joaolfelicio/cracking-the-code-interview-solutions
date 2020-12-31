using System.Collections.Generic;

namespace BookReader
{
    public class BookReaderSystem
    {
        public BookReaderSystem()
        {
            BookStore = new BookStore();
        }

        public UserManager UserManager { get; private set; }
        public BookStore BookStore { get; }
    }
}