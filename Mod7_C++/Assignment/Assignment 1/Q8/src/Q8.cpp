#include <iostream>
#include <string>
using namespace std;

// Define a structure with member functions
struct Person {
    string name;
    int age;
    float height;

    // Member function to initialize data members
    void initialize(const string& pName, int pAge, float pHeight) {
        name = pName;
        age = pAge;
        height = pHeight;
    }

    // Member function to display data members
    void display() const {
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Height: " << height << "ft" << endl;
    }
};

int main() {
    // Create a structure instance
    Person p;

    // Initialize the structure using the member function
    p.initialize("Riya Singh", 25, 5.0);

    // Display the structure's data using the member function
    p.display();

    return 0;
}
