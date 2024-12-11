#include<stdio.h>

int main(){
	int num1 = 5, num2 = 7;

	int *ptr = &num1;

	printf("Value of num1 using variable: %d\n", num1);
	printf("Value of num1 using pointer: %d\n", *ptr);

	ptr = &num2;

	printf("Value of num2 using variable: %d\n", num2);
	printf("Value of num2 using pointer: %d\n", *ptr);

	return 0;

}
