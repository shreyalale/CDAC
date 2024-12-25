namespace ExpenseLibrary
{
    public class ExpenseManager
    {
        private List<Expense> _expenses = new List<Expense>();  // List of expenses
        private int _nextId = 1;  // Next available ID

        public void AddExpense(string category, string description, decimal amount)
        {
             _expenses.Add(new Expense
            {
                Id = _nextId++,
                Category = category,
                Description = description,
                Amount = amount,
                Date = DateTime.Now
            });

        }   
            public List<Expense> ListAllExpenses() => _expenses;

            public decimal TotalExpenses() => _expenses.Sum(e => e.Amount);

            public List<Expense> ExpensesForCategory(string category) =>
             _expenses.Where(e => e.Category.Equals(category, StringComparison.OrdinalIgnoreCase)).ToList();

           
        }
        
    }
