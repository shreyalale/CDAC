#include<stdio.h>

int main(){
	int x = 10, y = 20;

	//i. Pointer to a const value
	const int *ptr1 = &x;
	printf("Value of x throught ptr1: %d\n", *ptr1);

	// *ptr1 = 15; // Error: Cannot modify the value pointed to by ptr1
	ptr1 = &y;
	printf("Value of y through ptr1: %d\n", *ptr1);

	// ii. const pointer to a value
	int *const ptr2 = &x; // Constant pointer to an integer
	printf("Value of x through ptr2: %d\n", *ptr2);

	*ptr2 = 30;  // Allowed: Value at the address can be modified
	// ptr2 = &y; // Error: Cannot change the address stored in ptr2
	printf("Modified value of x through ptr2: %d\n", *ptr2);

	// iii. const pointer to a const value
	int *const ptr3 = &x;
	printf("Value of x through ptr2: %d\n", *ptr3);


    // *ptr3 = 40; // Error: Cannot modify the value pointed to by ptr3
    // ptr3 = &y;  // Error: Cannot change the address stored in ptr3

	return 0;

}

