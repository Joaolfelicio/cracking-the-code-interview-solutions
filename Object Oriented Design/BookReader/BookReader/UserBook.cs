using System.Collections.Generic;

namespace BookReader
{
    public class UserBook : Book
    {
        public UserBook(Book book)
        {
        }

        public HashSet<HighLight> HighLights { get; private set; }
        public Page CurrentPage { get; private set; }
        public bool HasFinishedBook { get; private set; }
        public bool DeleteHighLight(HighLight highLight) => HighLights.Remove(highLight);
        public bool AddHighLight(HighLight highLight) => HighLights.Add(highLight);

        public bool NextPage()
        {
            if (CurrentPage.IsLastPage()) return false;

            var nextPage = Pages[CurrentPage.PageNumber + 1];
            
            ChangePage(nextPage);
            if (nextPage.IsLastPage()) HasFinishedBook = true;

            return true;
        }

        public bool PrevPage()
        {
            if(CurrentPage.IsFirstPage()) return false;
            
            var prevPage = Pages[CurrentPage.PageNumber - 1];

            ChangePage(prevPage);
            if(HasFinishedBook) HasFinishedBook = false;

            return true;
        }

        public void ChangePage(Page page) => CurrentPage = page;
    }
}