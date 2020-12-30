using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class Author
    {
        public string Name { get; private set; }
        public string Age { get; private set; }
        public List<Book> Books { get; private set; }
    }
}
