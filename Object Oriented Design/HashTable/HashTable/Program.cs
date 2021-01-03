using System;

namespace HashTable
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            var test = new HashTable<int>();

            Console.WriteLine(test.Add(2555, 123));
            Console.WriteLine(test.Contains(0));
            Console.WriteLine(test.Contains(0));
            Console.WriteLine(test.Add(1, 123));
            Console.WriteLine(test.Add(0, 12344));
            Console.WriteLine(test.Remove(0));
            Console.WriteLine(test.Remove(0));
            Console.WriteLine(test.Add(1, 12344));
            Console.WriteLine(test.Add(2, 12344));
            Console.WriteLine(test.Add(2, 12344));
            Console.WriteLine(test.Add(3, 12344));
            Console.WriteLine(test.Add(4, 12344));
            Console.WriteLine(test.Add(5, 12344));
            Console.WriteLine(test.Add(6, 12344));
            Console.WriteLine(test.Add(7, 12344));
            Console.WriteLine(test.Add(8, 12344));
            Console.WriteLine(test.Add(9, 12344));

            Console.ReadLine();
        }
    }
}
