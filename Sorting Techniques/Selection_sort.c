#include <stdio.h>

// The number of comparsion is n * n+1 / 2 
// So the time comparsion is n**2
void swap(int *x, int *y){
    int temp = *x;
    *x = *y;
    *y = temp;
}
void selectionSort(int A[], int number){
    int i,j,k;

    for(i=0;i<number-1;i++){
         for(j,k=0;j<number;j++){
             if(A[j]<A[k])
             k=j;
         }
         swap(&A[i], &A[k]);
    }
}

int main()
{
    int A[]={11,13,7,12,16,9,24,5,10,3},n=10;
    selectionSort(A,n);
    int i;
    for(i=0;i<10;i++)
    {
    printf("%d ",A[i]); 
    }
    printf("\n");
    return 0;
}
