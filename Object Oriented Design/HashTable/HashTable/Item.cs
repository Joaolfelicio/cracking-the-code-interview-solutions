namespace HashTable
{
    public class Item<T>
    {
        public Item(T key, T value)
        {
            Key = key;
            Value = value;
        }

        public T Key { get; set; }
        public T Value { get; set; }
    }
}