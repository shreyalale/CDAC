using System;

public class Student
{
    // Properties
    public string Name { get; set; }
    public int RollNumber { get; set; }
    public double Marks { get; set; }
    public string Grade { get; private set; }

    // Method Overloading to Calculate Grade
    public void CalculateGrade(double totalMarks, double passingMarks = 40)
    {
        Grade = totalMarks >= passingMarks ? "Pass" : "Fail";
    }

    public void CalculateGrade(double subject1, double subject2, double subject3, double passingMarks = 40)
    {
        double totalMarks = subject1 + subject2 + subject3;
        CalculateGrade(totalMarks, passingMarks);
    }

    // Named and Positional Parameters to Add Student
    public void AddStudent(string name, int rollNumber, double marks)
    {
        Name = name;
        RollNumber = rollNumber;
        Marks = marks;
    }

    public override string ToString()
    {
        return $"Name: {Name}, Roll Number: {RollNumber}, Marks: {Marks}, Grade: {Grade}";
    }
}
