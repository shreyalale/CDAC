//#include<stdio.h>
//
//struct Person {
//	char name[50];
//	int age;
//	float height;
//};
//
// int main(){
//	 //initialize the structure
//	 struct Person p ={"Riya Singh", 25, 5.0};
//
//	 //Print the structure members
//	 printf("Name: %s\n", p.name);
//	 printf("Age: %d\n", p.age);
//	 printf("Height: %.1f ft\n", p.height);
//
//	 return 0;
// }

#include <iostream>
#include  <string>
using namespace std;

struct Person {
	char name[50];
	int age;
	float height;
};

int main(){
	//Initialize the structure
	Person p ={"Riya Singh", 25, 5.1f};

	cout << "Name: " << p.name << endl;
	cout << "Age: " << p.age << endl;
	cout << "Height: " << p.height << endl;




}
