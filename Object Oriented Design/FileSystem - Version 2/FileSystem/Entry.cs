
using System;

namespace FileSystem
{
    public abstract class Entry
    {
        public Entry(string name, Directory directory)
        {
            Name = name;
            Parent = directory;
            Created = DateTime.Now;
            LastUpdated = DateTime.Now;
            LastAccessed = DateTime.Now;
        }

        protected Directory Parent { get; set; }
        protected DateTime Created { get; }
        protected DateTime LastUpdated { get; set; }
        protected DateTime LastAccessed { get; set; }
        protected string Name { get; set; }

        public bool HasParent() => Parent != null;

        public bool DeleteDir()
        {
            if (!HasParent()) return false;
            return Parent.DeleteEntry(this);
        }

        public abstract int Size();

        public string GetFullPath()
        {
            if (!HasParent()) return Name;
            return $"{Parent.GetFullPath()}/{Name}";
        }
    }
}