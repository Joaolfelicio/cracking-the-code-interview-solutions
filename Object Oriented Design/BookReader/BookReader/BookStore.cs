using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class BookStore
    {
        public Dictionary<Guid, Book> Books { get; private set; }
        public Book GetBook(Guid id)
        {
            if(Books.ContainsKey(id)) return Books[id];
            return null;
        }
        public bool AddBook(Book book)
        {
            if (Books.ContainsKey(book.Id)) return false;
            Books.Add(book.Id, book);
            return true;
        }

        public bool RemoveBook(Guid id)
        {
            if (!Books.ContainsKey(id)) return false;
            
            Books.Remove(id);
            return true;
        }
    }
}
