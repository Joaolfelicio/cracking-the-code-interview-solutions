using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net.Http.Headers;

namespace FileSystem
{
    public class Directory : ObjectSystem
    {
        public Directory(string name, string fullName, Directory directory) : base(name, fullName, directory)
        {
        }

        public Dictionary<string, ObjectSystem> ObjectSystemsDict { get; } = new Dictionary<string, ObjectSystem>();
        public List<ObjectSystem> ObjectSystems { get; } = new List<ObjectSystem>();

        protected override bool Rename(string newName)
        {
            var success = Directory.ChildDictNameChanged(newName, this);

            FullName = FullName.Replace(FullName, newName);
            Name = newName;

            UpdateLastModifiedDate();

            return success;
        }

        private bool AddObjectSystem(ObjectSystem objectSystem)
        {
            if (ObjectSystemsDict.ContainsKey(objectSystem.Name)) return false;

            ObjectSystemsDict.Add(objectSystem.Name, objectSystem);
            ObjectSystems.Add(objectSystem);

            return true;
        }

        public bool CreateFile(string name)
        {
            if (string.IsNullOrWhiteSpace(name)) return false;

            var uniqueName = name;
            int i = 1;

            // If file name already exists, append a (1), (2), etc..
            while (ObjectSystemsDict.ContainsKey(uniqueName))
            {
                var dotIndex = name.LastIndexOf('.') - 1;

                if (dotIndex < 0) return false;

                uniqueName = name.Insert(dotIndex, $" ({i})");
                i++;
            }

            var file = new File(uniqueName, GetFullPath(uniqueName), this);

            return AddObjectSystem(file);
        }

        public bool CreateDirectory(string name)
        {
            if (string.IsNullOrWhiteSpace(name)) return false;

            var uniqueName = name;
            int i = 1;

            // If file name already exists, append a (1), (2), etc..
            while (ObjectSystemsDict.ContainsKey(uniqueName))
            {
                uniqueName = name.Insert(name.Length - 1, $" ({i})");
                i++;
            }

            var directory = new Directory(uniqueName, GetFullPath(uniqueName), this);

            return AddObjectSystem(directory);
        }
        
        public string GetFullPath(string name) => Path.Combine(FullName, name);

        public bool DeleteObject(ObjectSystem objectSystem)
        {
            if (!ObjectSystemsDict.ContainsKey(objectSystem.Name)) return false;

            return ObjectSystemsDict.Remove(objectSystem.Name) && ObjectSystems.Remove(objectSystem);
        }

        public List<File> GetFiles() => ObjectSystems.Where(x => x.GetType() == typeof(File)).Cast<File>().ToList();
        
        public List<Directory> GetDirectories() => ObjectSystems.Where(x => x.GetType() == typeof(Directory)).Cast<Directory>().ToList();

        public bool ChildDictNameChanged(string newName, Directory directory)
        {
            ObjectSystemsDict[newName] = directory;
            return ObjectSystemsDict.Remove(directory.Name);
        }

        public File FindFile(string name)
        {
            var queue = new Queue<Directory>();

            queue.Enqueue(this);

            while (queue.Count > 0)
            {
                var dir = queue.Dequeue();

                if (dir.ObjectSystemsDict.ContainsKey(name)) return (File) dir.ObjectSystemsDict[name];

                foreach(var nestedDir in GetDirectories()) queue.Enqueue(nestedDir);
            }
            return null;
        }
    }
}