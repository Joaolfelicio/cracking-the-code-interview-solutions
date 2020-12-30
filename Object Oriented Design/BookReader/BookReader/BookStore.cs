using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class BookStore
    {
        public List<Book> Books { get; private set; }
        public Book GetBook(Book book) => Books.Find(x => x == book);
        public Book GetBookByGenre(Genre genre) => Books.Find(x => x.Genre == genre);
        public Book GetBooksByAuthor(Author author) => Books.Find(x => x.Author == author);
        public Book GetBooksByName(string name) => Books.Find(x => x.Name.Contains(name));
    }
}
