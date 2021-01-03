using System;
using System.Collections.Generic;

namespace HashTable
{
    public class HashTable<T>
    {
        public HashTable(int capacity = 8)
        {
            Capacity = capacity;
            Size = 0;
            Items = new List<Item<T>>[capacity];
        }

        public int Capacity { get; private set; }
        public int Size { get; private set; }
        private List<Item<T>>[] Items { get; set; }
        private const float ReduceThreshold = 0.25f;

        public bool Add(T key, T value)
        {
            var newItem = new Item<T>(key, value);

            var success = Add(newItem, Items);

            if (success) Size++;

            if(ShouldIncreaseCapacity()) IncreaseCapacity();

            return success;
        }
        public T Get(T key)
        {
            var hashedKey = HashKey(key);

            if (!Contains(hashedKey, key, Items)) throw new Exception("The key doesn't match any value");

            foreach (var item in Items[hashedKey])
            {
                if (item.Key.Equals(key)) return item.Value;
            }

            return default;
        }
        public bool Contains(T key)
        {
            var hashedKey = HashKey(key);

            return Contains(hashedKey, key, Items);
        }
        public bool Remove(T key)
        {
            var hashedKey = HashKey(key);

            if (!Contains(hashedKey, key, Items)) return false;

            foreach (var item in Items[hashedKey])
            {
                if (item.Key.Equals(key))
                {
                    var targetItem = item;
                    var success = Items[hashedKey].Remove(targetItem);

                    if (success) Size--;

                    if(ShouldReduceCapacity()) ReduceCapacity();

                    return success;
                }
            }
            return false;
        }
        
        private bool Add(Item<T> item, List<Item<T>>[] items)
        {
            var hashedKey = HashKey(item.Key);

            if (Contains(hashedKey, item.Key, items)) return false;

            if (items[hashedKey] == null) items[hashedKey] = new List<Item<T>>();

            items[hashedKey].Add(item);

            return true;
        }
        private bool Contains(int hashedKey, T key, List<Item<T>>[] items)
        {
            if (items[hashedKey] == null) return false;

            foreach (var item in items[hashedKey])
            {
                if (item.Key.Equals(key)) return true;
            }

            return false;
        }
        private void IncreaseCapacity()
        {
            Capacity *= 2;
            FillArray();
        }
        private void ReduceCapacity()
        {
            Capacity /= 2;
            FillArray();
        }
        private void FillArray()
        {
            var newListItems = new List<Item<T>>[Capacity];

            foreach (var listOfItems in Items)
            {
                foreach (var item in listOfItems)
                {
                    Add(item, newListItems);
                }
            }

            Items = newListItems;
        }

        private bool ShouldIncreaseCapacity() => Capacity == Size;
        // Should only decrease if the array capacity is above 8
        private bool ShouldReduceCapacity() => Math.Round(Capacity * ReduceThreshold) >= Size && Capacity > 8;
        private int HashKey(T value) => value.GetHashCode() % Capacity;
    }
}