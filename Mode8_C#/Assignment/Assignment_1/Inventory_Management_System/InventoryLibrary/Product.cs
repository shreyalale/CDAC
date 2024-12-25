using System;

public class Product
{
    // Properties
    public int ID { get; set; }
    public string Name { get; set; }
    public decimal Price { get; set; } // Changed to decimal for currency precision
    public int Stock { get; set; }

    // Constructor
    public Product(int id, string name, decimal price, int stock)
    {
        ID = id;
        Name = name;
        Price = price;
        Stock = stock;
    }

    // Method to calculate the total value of stock
    public decimal CalculateTotalValue(params int[] quantities)
    {
        decimal totalValue = 0;

        // Local function to validate stock
        void ValidateStock(int quantity)
        {
            if (quantity > Stock)
                throw new InvalidOperationException($"Not enough stock for {Name}. Available: {Stock}");
        }

        foreach (var quantity in quantities)
        {
            ValidateStock(quantity); // Validate stock
            totalValue += quantity * Price; // Arithmetic uses decimal type
        }

        return totalValue;
    }

    public override string ToString()
    {
        return $"ID: {ID}, Name: {Name}, Price: {Price:C}, Stock: {Stock}";
    }
}
