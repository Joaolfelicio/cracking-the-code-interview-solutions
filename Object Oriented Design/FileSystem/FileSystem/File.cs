namespace FileSystem
{
    public class File : ObjectSystem
    {
        public File(string name, string fullName, Directory directory) : base(name, fullName, directory)
        {
        }
        
        protected override bool Rename(string newName)
        {
            if (string.IsNullOrWhiteSpace(newName)) return false;

            Name = newName + GetExtension();
            UpdateLastModifiedDate();
            return true;
        }

        public string GetExtension()
        {
            var dotIndex = Name.LastIndexOf('.');

            if (dotIndex == -1) return string.Empty;

            return Name.Substring(dotIndex);
        }

        public string GetNameWithOutExtension()
        {
            var dotIndex = Name.LastIndexOf('.');

            if (dotIndex == -1) return Name;

            return Name.Substring(0, dotIndex - 1);
        }
    }
}