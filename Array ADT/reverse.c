#include<stdio.h>
#include<stdlib.h>
struct Array
{
 int A[10];
 int size;
 int length;
};


 void Display(struct Array arr)
 {
 int i;
 printf("\nElements are\n");
 for(i=0;i<arr.length;i++)
 printf("%d ",arr.A[i]);
 }


void swap(int *x,int *y)
 {
 int temp=*x;
 *x=*y;
 *y=temp;
 }

 void reverse_array_option1(struct Array *array)
 {
     int *B;
     int i,j;
     B= (int *) malloc(array->length*sizeof(int));
     for(i=0, j=array->length-1;i<array->length;i++,j--)
     {
         B[i]=array->A[j];
     }
     
     for(j=0;j<array->length;j++)
     {
         array->A[j]=B[j];
     }
 }
void reverse_array_option2(struct Array *array)
 {
     int *B;
     int i,j;
    
     for(i=0, j=array->length-1;i<array->length;i++,j--)
     {
        swap(&array->A[i],&array->A[j]);
     }
     
     
 }

 int main()
 {
    
    struct Array array={{1,2,3,4},4,4};
    reverse_array_option1(&array);
    Display(array);

    reverse_array_option2(&array);
    Display(array);
    return 0;
 }