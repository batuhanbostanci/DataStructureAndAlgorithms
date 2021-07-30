#include<stdio.h>
#include<stdlib.h>



//if we gonna do merging arrays, we should make first sorted in two arrays
// otherwise it is not possible. Also sorting must be another different
//array 

//if the time complexity like m+n that means there is merging in here **

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

struct Array* Merge(struct Array *array1, struct Array *array2)
{
    int i,j,k;
    i=0;
    j=0;
    k=0;
    struct Array *array3 = (struct Array *) malloc(sizeof(struct Array));
    while(i<array1->length && j<array2->length)
    {
            if(array1->A[i]<array2->A[j])
            array3->A[k++]=array1->A[i++];
            else
            array3->A[k++]=array2->A[j++];
    }
    for(;i<array1->length;i++)
    {
        array3->A[k++]= array1->A[i];
    }
    
    for(;j<array2->length;i++)
    {
        array3->A[k++]= array2->A[j];
    }
        array3->length = array1->length+array2->length;
        array3->size=10;

        return array3;
}


int main()
{
    struct Array array1 ={{2,6,10,15,25},10,5};
    struct Array array2 ={{3,4,7,18,20},10,5};
    struct Array *array3;
    array3= Merge(&array1,&array2);
    Display(*array3);
    return 0;
}

