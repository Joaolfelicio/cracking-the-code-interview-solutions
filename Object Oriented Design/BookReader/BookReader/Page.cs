using System;
using System.Collections.Generic;
using System.Text;

namespace BookReader
{
    public class Page
    {
        public Book Book { get; private set; }
        public int PageNumber { get; private set; }
        public string Content { get; private set; }

        public bool IsLastPage() => PageNumber == Book.Pages.Length - 1;
        public bool IsFirstPage() => PageNumber == 0;
    }
}
