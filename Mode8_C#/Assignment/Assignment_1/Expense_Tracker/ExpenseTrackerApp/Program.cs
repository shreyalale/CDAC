// See https://aka.ms/new-console-template for more information

using ExpenseLibrary;

class Program
{
    static void Main()
    {
        ExpenseManager mgr = new ExpenseManager();
        bool running = true;

        while(running)
        {
            Console.WriteLine("Personal Expense Tracker");
            Console.WriteLine("1. Add Expense");
            Console.WriteLine("2. List All Expenses");
            Console.WriteLine("3. Total Expenses");
            Console.WriteLine("4. Expenses by Category");
            Console.WriteLine("5. Exit");
            Console.Write("Enter your choice: ");
            string choice = Console.ReadLine();

            switch(choice)
            {
                case "1":
                    Console.Write("Enter category: ");
                    string category = Console.ReadLine();
                    Console.Write("Enter description: ");
                    string description = Console.ReadLine();
                    Console.Write("Enter amount: ");
                    decimal amount = decimal.Parse(Console.ReadLine());
                    mgr.AddExpense(category, description, amount);
                    Console.WriteLine("Expense added");
                    break;
                case "2":
                    Console.WriteLine("All expenses:");
                    foreach(Expense e in mgr.ListAllExpenses())
                    {
                        Console.WriteLine(e);
                    }
                    break;
                case "3":
                    Console.WriteLine($"Total expenses: {mgr.TotalExpenses():C}");
                    break;
                case "4":
                    Console.Write("Enter category: ");
                    string cat = Console.ReadLine();
                    var expenses = mgr.ExpensesForCategory(cat);
                    if(expenses.Count > 0)
                    {
                        Console.WriteLine("Filtered expenses:");
                        foreach(var e in expenses)
                        {
                            Console.WriteLine(e);
                        }
                    } else {
                        Console.WriteLine("No expenses found for category");
                    }  
                    break;
                case "5":
                    running = false;
                    Console.WriteLine("Goodbye!");
                    break;
                default:
                    Console.WriteLine("Invalid choice");
                    break;  
        }
    }
}
}