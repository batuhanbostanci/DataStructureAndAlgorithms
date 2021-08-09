#include <stdio.h>

//single missing element in sorted array

struct Array 
{
    int A[10];
    int size;
    int length;
};


int single_missing_element(struct Array array )
{
    int lowest = array.A[0];
    int highetst = array.A[array.length-1];
    int diff = lowest;

    for(int i=0;i<array.length;i++)
    {
        if(array.A[i] - i !=diff)
        {
            printf("The missing elements is %d \n", (diff + i));
            break;
        }
    }
}


int main()
{
    struct Array array ={{1,2,3,5},4,10};
    single_missing_element(array);
    return 0;
}


