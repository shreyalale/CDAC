#include <iostream>
#include <string>
using namespace std;

// Define a structure to represent a student
struct Student {
    string name;
    int age;
    float marks;

    // Member function to input student details
    void input() {
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter Age: ";
        cin >> age;
        cout << "Enter Marks: ";
        cin >> marks;
    }

    // Member function to display student details
    void display() const {
        cout << "Name: " << name << ", Age: " << age << ", Marks: " << marks << endl;
    }
};

int main() {
    const int numStudents = 5; // Number of students
    Student students[numStudents]; // Array of students

    // Input details for each student
    cout << "Enter details of " << numStudents << " students:\n";
    for (int i = 0; i < numStudents; ++i) {
        cout << "\nStudent " << i + 1 << ":\n";
        students[i].input();
    }

    // Display the list of students
    cout << "\nList of Students:\n";
    for (int i = 0; i < numStudents; ++i) {
        cout << "Student " << i + 1 << ": ";
        students[i].display();
    }

    return 0;
}
