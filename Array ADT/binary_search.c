#include <stdio.h>


//for binary search the array must be sorted becasue its divide the list 2, an in every time it is going to divide it 
//self again 2 that's way we need to divide the list 
//
//Best time complaxity is O(1)
//Worst case time complaxity is O(log n)
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
void swap(int *x, int *y){
    int temp;
    temp = *x;
    *x=*y;
    *y=temp;
};

int Recursion_binary_search(int array[],int l,int h, int key)//recursive version
{
  int mid = (l+h)/2;
    if(l<=h)
    {
        if(key==array[mid])
        {
            return mid;
        }else if(key<array[mid])
        {
            return Recursion_binary_search(array, l, mid-1, key);
        }
        else{
            return Recursion_binary_search(array,mid+1,h,key);
        }
    }
    return -1;
}

int Binary_search(struct Array array,int key)//normal
{
    int l,h,mid;
    l=0;
    h=array.length-1;
    while(l<=h)
    {
        mid = (h+l)/2;
        if(key==array.A[mid])
        {
            return mid;
        }else if(key<array.A[mid])
        {
            h=mid-1;
        }
        else
        {
            l=mid+1;
        }
        
    }
    return -1;
}
int main()
{ 
     struct Array array={{1,2,3,4,5},10,5};
     printf("%d ", Recursion_binary_search(array.A,0,array.length,90));
    return 0;
}