#include<stdio.h>

int main(){
	int *ptr = NULL;

	if(ptr == NULL){
		printf("Pointer is Null. \n");
	} else {
		printf("Value pointed to buy ptr: %d\n", *ptr);
	}
	int num = 10;
	ptr = &num;

	if(ptr != NULL) {
		printf("Pointer is not NULL. Value pointed to by ptr: %d\n", *ptr);
	}

	return 0;

}

