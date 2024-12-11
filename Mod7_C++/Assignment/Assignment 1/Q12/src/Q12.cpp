#include <iostream>
#include <string>
using namespace std;

class Employee {
private:
    string name;
    int id;
    float salary;

public:
    // Member function to initialize employee data
    void initialize(const string& empName, int empId, float empSalary) {
        name = empName;
        id = empId;
        salary = empSalary;
    }

    // Member function to display employee data
    void display() const {
        cout << "Name: " << name << ", ID: " << id << ", Salary: " << salary << endl;
    }
};

int main() {
    // Create multiple Employee objects
    Employee emp1, emp2, emp3;

    // Initialize employee data
    emp1.initialize("Riya", 101, 50000.0);
    emp2.initialize("Roshan", 102, 60000.0);
    emp3.initialize("Rahul", 103, 55000.0);

    // Display employee data
    cout << "Employee Details:\n";
    emp1.display();
    emp2.display();
    emp3.display();

    return 0;
}
