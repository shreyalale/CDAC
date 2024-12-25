using System;
using System.Collections.Generic;

namespace LibLibrary;
class Program
{
    static void Main()
    {
        List<Book> library = new List<Book>();
        library.Add(new Book("The Hobbit", "J.R.R. Tolkien"));
        library.Add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien"));
        library.Add(new Book("1984", "J.R.R. Tolkien"));

        bool running = true;

        while(running)
        {
            Console.WriteLine("Library Management System");
            Console.WriteLine("1. List books");
            Console.WriteLine("2. Borrow book");
            Console.WriteLine("3. Return book");
            Console.WriteLine("4. Exit");
            Console.Write("Enter a number: ");
            string input = Console.ReadLine();

            switch(input)
            {
                case "1":
                Console.WriteLine("Books:");
                    foreach(var book in library)
                    {
                        Console.WriteLine(book);
                    }
                    break;
                case "2":
                    Console.Write("Enter the title of the book to borrow: ");
                    string borrowTitle = Console.ReadLine();
                    var bookToBorrow = library.Find(b => b.Title.Equals(borrowTitle, StringComparison.OrdinalIgnoreCase));
                    if (bookToBorrow != null)
                    {
                        bookToBorrow.Borrow();
                    } else {
                        Console.WriteLine("Book not found");
                    }
                    break;
                case "3":
                    Console.Write("Enter the title of the book you want to return: ");
                   string returnTitle = Console.ReadLine();
                   var bookToReturn = library.Find(b => b.Title.Equals(returnTitle, StringComparison.OrdinalIgnoreCase));
                    if (bookToReturn != null)
                    {
                        bookToReturn.Return();
                    } else {
                        Console.WriteLine("Book not found");
                    }
                    break;
                case "4":
                    running = false;
                    Console.WriteLine("Goodbye!");
                    break;
                default:
                    Console.WriteLine("Invalid input");
                    break;
            }
        }
    }
}
