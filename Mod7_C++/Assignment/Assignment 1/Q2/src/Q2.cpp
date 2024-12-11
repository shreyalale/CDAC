#include<stdio.h>

int main(){
	int *wildptr;

	int num = 20;
	wildptr = &num;

	printf("Value of num using wildptr: %d\n", *wildptr);

	return 0;

}

