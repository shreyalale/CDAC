using System;
using System.Linq;

class Program
{
    static void Main()
    {
        Console.Write("Input the string:");
        string input = Console.ReadLine();

        var frequency = from ch in input
                        group ch by ch into grouped
                        select new { Character = grouped.Key, Count = grouped.Count() };

        Console.WriteLine("The Frequency of characters are:");
        foreach (var item in frequency)
        {
            Console.WriteLine($"Character {item.Character}: {item.Count} time {(item.Count > 1 ? "s" : "")}");
        }
    }
}