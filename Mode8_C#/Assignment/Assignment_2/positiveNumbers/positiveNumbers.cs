using System;
using System.Linq;

class positiveNumbers
{
    static void Main()
    {
        int[] numbers = { -1, 2, 3, 4, 5, -6, 7, 8, 9, -10 };

        var query = from num in numbers
                    where num > 0
                    where num <= 11
                    select num;

        Console.WriteLine("The positive numbers are:");
        foreach (var num in query)
        {
            Console.WriteLine(num + " ");
        }
    }
}