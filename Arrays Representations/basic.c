#include <stdio.h>
#include <stdlib.h>//for using malloc function *important 

//Basic staffs just for the remember in c and c++

// P = new int[5] -> c++
// P = (int *) malloc(5*sizeof(int)); -> c
//delete []p -> c++
// free(p) -> c

//to acces in heap i have to use pointer while declare or using arrays in my code 

int main()
{
    int A[5] = {1,2,3,4,5}; //stack
    int *p;
    p=(int *)malloc(5*sizeof(int)); // heap memory 
    
    return 0;
}