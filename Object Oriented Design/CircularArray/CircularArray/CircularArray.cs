using System;
using System.Collections;
using System.Collections.Generic;

namespace CircularArray
{
    public class CircularArray<T>
    {
        public T[] Items { get; set; }
        private int Head = 0;

        public CircularArray(int size)
        {
            Items = new T[size];
        }

        private int Convert(int index)
        {
            if (index < 0) index += Items.Length;
            return (Head + index) % Items.Length;
        }

        public void Rotate(int shiftRight) => Head = Convert(shiftRight);

        public T Get(int index)
        {
            if( index < 0 || index >= Items.Length) throw new IndexOutOfRangeException();

            return Items[Convert(index)];
        }

        public void Set(int index, T item) => Items[Convert(index)] = item;
    }
}