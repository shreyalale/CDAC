using System;

class Program
{
    static void Main(string[] args)
    {
        List<Student> students = new List<Student>();
        bool running = true;

        while (running)
        {
            Console.WriteLine("\nStudent Management System");
            Console.WriteLine("1. Add Student");
            Console.WriteLine("2. Calculate Grade (Total Marks)");
            Console.WriteLine("3. Calculate Grade (Subject-wise Marks)");
            Console.WriteLine("4. Display Student Details");
            Console.WriteLine("5. Exit");
            Console.Write("Enter your choice: ");
            string choice = Console.ReadLine();

            switch (choice)
            {
                case "1":
                    Console.Write("Enter Name: ");
                    string name = Console.ReadLine();
                    Console.Write("Enter Roll Number: ");
                    int rollNumber = int.Parse(Console.ReadLine());
                    Console.Write("Enter Marks: ");
                    double marks = double.Parse(Console.ReadLine());

                    Student student = new Student();
                    student.AddStudent(name: name, rollNumber: rollNumber, marks: marks);
                    students.Add(student);
                    Console.WriteLine("Student added successfully!");
                    break;

                case "2":
                    if (students.Count == 0)
                    {
                        Console.WriteLine("No students found! Add a student first.");
                    }
                    else
                    {
                        Console.Write("Enter Total Marks for Grade Calculation: ");
                        double totalMarks = double.Parse(Console.ReadLine());

                        foreach (var s in students)
                        {
                            s.CalculateGrade(totalMarks);
                        }

                        Console.WriteLine("Grades calculated successfully for all students!");
                    }
                    break;

                case "3":
                    if (students.Count == 0)
                    {
                        Console.WriteLine("No students found! Add a student first.");
                    }
                    else
                    {
                        Console.Write("Enter Marks for Subject 1: ");
                        double subject1 = double.Parse(Console.ReadLine());
                        Console.Write("Enter Marks for Subject 2: ");
                        double subject2 = double.Parse(Console.ReadLine());
                        Console.Write("Enter Marks for Subject 3: ");
                        double subject3 = double.Parse(Console.ReadLine());

                        foreach (var s in students)
                        {
                            s.CalculateGrade(subject1, subject2, subject3);
                        }

                        Console.WriteLine("Grades calculated successfully for all students!");
                    }
                    break;

                case "4":
                    if (students.Count == 0)
                    {
                        Console.WriteLine("No students found!");
                    }
                    else
                    {
                        Console.WriteLine("Student Details:");
                        foreach (var s in students)
                        {
                            Console.WriteLine(s);
                        }
                    }
                    break;

                case "5":
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
