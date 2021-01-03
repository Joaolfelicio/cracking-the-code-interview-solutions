using System;

namespace FileSystem
{
    public abstract class ObjectSystem
    {
        public ObjectSystem(string name, string fullName, Directory directory)
        {
            Name = name;
            FullName = fullName;
            Directory = directory;
            CreatedDate = DateTime.Now;
        }

        public Directory Directory { get; protected set; }
        public string FullName { get; protected set; }
        public string Name { get; protected set; }
        public DateTime CreatedDate { get; }
        public DateTime LastModifiedDate { get; private set; }

        protected void UpdateLastModifiedDate() => LastModifiedDate = DateTime.Now;
        public Directory GetDirectory() => Directory;

        protected abstract bool Rename(string newName);
    }
}