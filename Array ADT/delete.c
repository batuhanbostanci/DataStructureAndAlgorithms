#include <stdio.h>
#include <stdlib.h>

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
int delete(struct Array *array, int index)
{
    int x=0;
    int i;
    if(index >=0 && index<array->length)
    {
        x=array->A[index];
        for(i=index; i<array->length-1;i++)
        {
            array->A[i] = array->A[i+1];
        }
        array->length --;
        return x;
    }  
    return 0;
}

int main()
{
    struct Array array={{1,2,3,4,5},10,5};
    display(array);
    delete(&array,3);
    display(array);

    
    return 0;
}