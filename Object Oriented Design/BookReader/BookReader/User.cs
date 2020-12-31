using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class User
    {
        public User()
        {
            Id = new Guid();
        }

        public Guid Id { get; }
        public string Name { get; private set; }
        public UserBook CurrentBook { get; private set; }
        public Dictionary<Guid, UserBook> Books { get; private set; }

        public void BuyBook(Book book) => Books.Add(book.Id, new UserBook(book));
        public bool DeleteBook(UserBook book) => Books.Remove(book.Id);
        public bool HasAnyBooks() => Books.Count > 0;
        public bool IsReadingAnyBook() => CurrentBook != null;
        public bool HasBook(UserBook book) => Books.ContainsKey(book.Id);
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
