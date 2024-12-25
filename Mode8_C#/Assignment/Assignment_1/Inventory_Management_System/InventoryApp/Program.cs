using System;

class Program
{
    static void Main()
    {
        List<Product> products = new List<Product>();

        bool running = true;

        while (running)
        {
            Console.WriteLine("\nInventory Management System");
            Console.WriteLine("1. Add Product");
            Console.WriteLine("2. View Inventory");
            Console.WriteLine("3. Calculate Total Value of Stock");
            Console.WriteLine("4. Exit");
            Console.Write("Enter your choice: ");
            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1":
                    Console.Write("Enter Product ID: ");
                    int id = int.Parse(Console.ReadLine());
                    Console.Write("Enter Product Name: ");
                    string name = Console.ReadLine();
                    Console.Write("Enter Product Price: ");
                    decimal price = decimal.Parse(Console.ReadLine());
                    Console.Write("Enter Product Stock: ");
                    int stock = int.Parse(Console.ReadLine());

                    Product product = new Product(id, name, price, stock);
                    products.Add(product);
                    Console.WriteLine("Product added successfully!");
                    break;

                case "2":
                    if (products.Count == 0)
                    {
                        Console.WriteLine("Inventory is empty.");
                    }
                    else
                    {
                        Console.WriteLine("\nInventory:");
                        foreach (var item in products)
                        {
                            Console.WriteLine(item);
                        }
                    }
                    break;

                case "3":
                    if (products.Count == 0)
                    {
                        Console.WriteLine("Inventory is empty. Please add products first.");
                    }
                    else
                    {
                        Console.WriteLine("\nCalculate Total Value of Stock...");
                        decimal totalValue = 0;

                        foreach (var item in products)
                        {
                            try
                            {
                                Console.Write($"Enter quantity for {item.Name} (Stock: {item.Stock}): ");
                                int quantity = int.Parse(Console.ReadLine());
                                totalValue += item.CalculateTotalValue(quantity);
                            }
                            catch (Exception ex)
                            {
                                Console.WriteLine($"Error: {ex.Message}");
                            }
                        }
                        Console.WriteLine($"Total Value of Stock: {totalValue:C}");
                    }
                    break;

                case "4":
                    running = false;
                    Console.WriteLine("Exiting... Goodbye!");
                    break;

                default:
                    Console.WriteLine("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
