using System;
namespace LibLibrary;

public class Book
{
    public string Title { get; set; }
    public string Author { get; set; }
    public bool IsBorrowed { get; set; }

    public Book(string title, string author)
    {
        Title = title;
        Author = author;
        IsBorrowed = false;
    }
  
   public bool IsAvailable() => !IsBorrowed;
    
    public void Borrow()
    {
        if (IsBorrowed)
        {
           Console.WriteLine($"'{Title}' by {Author} is already borrowed");
        } else {
            IsBorrowed = true;
            Console.WriteLine($"You have borrowed '{Title}' by {Author}");
        } 
    }

    public void Return()
    {
        if (IsBorrowed)
        {
            IsBorrowed = false;
            Console.WriteLine($"You have returned '{Title}' by {Author}");
        } else {
            Console.WriteLine($"'{Title}' by {Author} is not borrowed");
        }
    }

    public override string ToString()
    {
        return $"Title: {Title}, Author: {Author}, Borrowed: {IsBorrowed}";
    }

}
