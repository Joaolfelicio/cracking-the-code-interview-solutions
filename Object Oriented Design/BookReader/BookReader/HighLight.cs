namespace BookReader
{
    public class HighLight
    {
        public HighLight(string note, string content)
        {
            Note = note;
            Content = content;
        }
        public string Note { get; set; }
        public string Content { get; set; }
    }
}