//finding multiple missing elements in array 
#include <stdio.h>
#include <stdlib.h>
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
void multiple_missing_element_orderOf_N_time(struct Array array)
{
    int lowest = array.A[0];
    int higest = array.A[array.length-1];
    int *tempArray = (int *) malloc( higest* sizeof(int));
    int i;
        for ( i = 0; i <higest; i++)
        {
            tempArray[i] =0;
        }
        
        for (int i = 0; i <higest; i++)
        {
            printf("%d ", tempArray[i]);
        }
        for( i=0;i<array.length;i++)
        {
          tempArray[array.A[i]]++;
        }

        for (int i = 0; i <higest; i++)
        {
            printf("%d ", tempArray[i]);
        }
        

   

}

int main()
{
    struct Array array ={{6,7,8,9,11,12,15,16,17,18,19},11,20};
    int h,l;
    h=array.length-1;
    l=array.A[h];
    
    
    int *tempArray = (int*)malloc(l*sizeof(int));
    int i;
    for ( i = 0; i < l; i++)
    {
         tempArray[i]=0;
         printf("%d ",tempArray[i]);
    }
    
    
   
    return 0;
}





