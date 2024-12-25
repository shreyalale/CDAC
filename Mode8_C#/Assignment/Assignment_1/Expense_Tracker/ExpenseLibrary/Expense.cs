namespace ExpenseLibrary
{
public class Expense
{
   public int Id {get; set;}
   public string Category {get; set;}
   public string Description {get; set;}
   public decimal Amount {get; set;}
   public DateTime Date {get; set;}

   public override string ToString()
   {
    return $"Id: {Id}, Category: {Category}, Description: {Description}, Amount: {Amount:C}, Date: {Date:d}";
   }
}
}