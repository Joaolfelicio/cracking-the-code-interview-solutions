using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class User
    {
        public string Name { get; private set; }
        public UserBook CurrentBook { get; private set; }
        public HashSet<UserBook> Books { get; private set; }

        public bool BuyBook(Book book) => Books.Add(new UserBook(book));
        public bool DeleteBook(UserBook book) => Books.Remove(book);
        public bool HasAnyBooks() => Books.Count > 0;
        public bool IsReadingAnyBook() => CurrentBook != null;
        public bool HasBook(UserBook book) => Books.Contains(book);
        public bool ReadBook(UserBook book)
        {
            if (HasBook(book))
            {
                CurrentBook = book;
                return true;
            }
            return false;
        }
    }
}
