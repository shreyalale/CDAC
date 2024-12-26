using System;
using System.Linq;

class Program
{
    static void Main()
    {
       
        int[] numbers = { 9, 8, 6, 5 };

     
        var query = from num in numbers
                    select new { Number = num, SqrNo = num * num };

        Console.WriteLine("The numbers and their squares are:");
        foreach (var item in query)
        {
            Console.WriteLine($"{{ Number = {item.Number}, SqrNo = {item.SqrNo} }}");
        }
    }
}
