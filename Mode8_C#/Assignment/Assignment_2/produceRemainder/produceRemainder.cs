using System;
using System.Linq;

class produceRemainder 
{
    static void Main() 
    {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
       
        var query = from num in numbers
                        where num % 2 == 0
                        select num;

        Console.WriteLine("The numbers which produce a remainder of 0 when divided by 2 are:");
        foreach (int num in query)
        {
            Console.WriteLine(num + " ");
        }
    }
}