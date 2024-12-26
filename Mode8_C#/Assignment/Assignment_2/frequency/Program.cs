using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static void Main()
    {
 
        int[] numbers = { 5, 9, 1, 5, 9, 5 };

        var frequency = from num in numbers
                        group num by num into grouped
                        select new { Number = grouped.Key, Count = grouped.Count() };

        Console.WriteLine("The number and the Frequency are:");
        foreach (var item in frequency)
        {
            Console.WriteLine($"Number {item.Number} appears {item.Count} times");
        }
    }
}
