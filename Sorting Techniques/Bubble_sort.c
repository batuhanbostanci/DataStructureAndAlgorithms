#include <stdio.h>

//(n-1) passes
//number of comp = 1+2+3+.....+n O(n square)
//max number of swaps same O(n square)
void swap(int *x, int *y)
{
    int temp =*x;
    *x=*y;
    *y=temp;
}

void BubbleSort(int array[], int length)
{
    int i,j;
    int flag=0;
    for(i=0;i<length-1;i++)
    {
        flag=0;
        for(j=0;j<length-1-i;j++)
        {
            if(array[j+1]>array[j])
            {
                swap(&array[j],&array[j+1]);
                flag=1;
            }
        }
        if(flag==0)
        break;
    }
}

int main()
{
     int A[]={11,13,7,12,16,9,24,5,10,3},n=10;

    BubbleSort(A,n);
    int i;
    for(i=0;i<10;i++)
     printf("%d ",A[i]);
     printf("\n");
    return 0;
}
