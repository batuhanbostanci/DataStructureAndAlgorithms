#include <stdio.h>
#include <stdlib.h>

struct Array 
{
    int A[10];
    int size;
    int length;
};

void Display(struct Array array)
{
    int i;
    printf("\n Elements are\n");
    for(i=0;i<array.length;i++)
        printf("%d ", array.A[i]);
}
int isSorted(struct Array array)
{
    int i;
    for(i=0;i<array.length-1;i++)
    {
        if(array.A[i]>array.A[i+1])      
            return 0;
           
    }
       return 1;
   
}
int main()
{
    struct Array arr1={{2,3,9,16,18,21,28,32,35},10,9};
    printf("%d",isSorted(arr1));
    Display(arr1);
    return 0;
}