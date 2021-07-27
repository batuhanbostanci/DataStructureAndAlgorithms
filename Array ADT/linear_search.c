
#include <stdio.h>

//Important, mostly we look at the worst case while comparing the time complexities, because avarege and the worst 
//case would be same 

struct Array 
{
 int A[10];
 int size;
 int length;
};
void display(struct Array array)
{
    int i;
    printf("\nElements are\n");
    for(i =0;i<array.length;i++)
    printf("%d ", array.A[i]);
}

int embriyonic_linear_search(struct Array array, int number)
{
    int i;
    for(i=0;i<array.length;i++)
    {
        if(number == array.A[i])
        {
            return i;
        }
    }
    return -1;
}
void swap(int *x, int *y){
    int temp;
    temp = *x;
    *x=*y;
    *y=temp;
};

int improving_linear_search(struct Array *array, int number)
{
    int i;
   for(i=0;i<array->length;i++)
    {
        if(number == array->A[i])
        {
           swap(&array->A[i], &array->A[0]);
            return i;
        }
    }
    return -1;
}

int main()
{
     struct Array array={{1,2,3,4,5},10,5};
     printf("%d ", improving_linear_search(&array,4));
    return 0;
}