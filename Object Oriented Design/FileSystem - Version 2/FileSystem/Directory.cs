using System;
using System.Collections.Generic;

namespace FileSystem
{
    public class Directory : Entry
    {
        public Directory(string name, Directory directory) : base(name, directory)
        {
            Contents = new List<Entry>();
        }

        protected List<Entry> Contents { get; set; }

        public override int Size()
        {
            var totalSize = 0;

            foreach (var content in Contents)
            {
                totalSize += content.Size();
            }

            return totalSize;
        }

        public int GetNumberOfFile()
        {
            var numOfFiles = 0;

            foreach (var content in Contents)
            {
                if (content.GetType() == typeof(Directory))
                {
                    numOfFiles++;
                    var dir = (Directory) content;
                    dir.GetNumberOfFile();
                }
                else if(Contents.GetType() == typeof(File))
                {
                    numOfFiles++;
                }
            }
            return numOfFiles;
        }

        public bool DeleteEntry(Entry entry) => Contents.Remove(entry);
        public void AddEntry(Entry entry) => Contents.Add(entry);
    }
}