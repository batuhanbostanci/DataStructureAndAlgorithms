#include <stdio.h>

//(n-1) passes
//number of comp = 1+2+3+.....+n O(n square)
//max number of swaps same O(n square)
//The benefit of insertion sort is using with linked list becasuse we don't have to shitfed elements in linked list
// This is design for the linked list 

void Insertion_sort(int array[], int length)
{
    int i,j,x;

    for(i=1;i<length;i++)
    {
        j=i-1;
        x=array[i];
        while(j>-1 && array[j]>x )
        {
            array[j+1]=array[j];
            j--;
        }
        array[j+1] = x;
    }
}

int main()
{
     int A[]={11,13,7,12,16,9,24,5,10,3},n=10;

    Insertion_sort(A,n);
    int i;
    for(i=0;i<10;i++)
     printf("%d ",A[i]);
     printf("\n");
    return 0;
}
