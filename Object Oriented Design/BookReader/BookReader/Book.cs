using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class Book
    {
        public Book()
        {
            Id = new Guid();
        }

        public Guid Id { get; }
        public string Name { get; private set; }
        public Author Author { get; private set; }
        public Genre Genre { get; private set; }
        public DateTime ReleaseDate { get; private set; }
        public Page[] Pages { get; private set; }
        public List<Book> Series { get; private set; }
    }
}
