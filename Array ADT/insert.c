#include <stdio.h>
#include<stdlib.h>


struct Array 
{
    int A[10];
    int size;
    int length;
};

void display(struct Array array)
{
    int i;
    printf("\nElements are \n");
    for(i=0;i<array.length;i++)
    printf("%d ", array.A[i]);

}
void append(struct Array *array, int x)
{
    if(array->length < array->size)
    array->A[array->length++]=x;
}
void insert(struct Array *array, int index, int x)
{
    int i;
    if(index>=0 && index <= array->length)
    {
        for(i= array->length; i>index;i--)
        array->A[i] =array->A[i-1];

        array->A[index] = x;
        array->length++;
    }

}
int main()
{
    struct Array array={{1,2,3,4,5},10,5};
    append(&array,10);
    display(array);

    insert(&array,2,78);
    display(array);
    return 0;
}