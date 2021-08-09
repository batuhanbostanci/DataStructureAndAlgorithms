//finding multiple missing elements in array 
#include <stdio.h>

//single missing element in sorted array

struct Array 
{
    int A[11];
    int size;
    int length;
};

void multiple_missing_element(struct Array array)
{
    int lowest = array.A[0];
    int diff = lowest;
        for(int i=0;i<array.length;i++)
        {
            if(array.A[i]-i !=diff)
            {
                while(diff<array.A[i]-i)
                {
                    printf("Missing elements is %d \n " ,diff+i);
                    diff++;
                }
            }
        }

}
int main()
{
    struct Array array ={{6,7,8,9,11,12,15,16,17,18,19},11,20};
    multiple_missing_element(array);
    return 0;
}





