namespace FileSystem
{
    public class File : Entry
    {
        public File(string name, Directory directory, int fileSize) : base(name, directory)
        {
            FileSize = fileSize;
        }

        public string Content { get; set; }
        public int FileSize { get; private set; }

        public override int Size() => FileSize;
    }
}