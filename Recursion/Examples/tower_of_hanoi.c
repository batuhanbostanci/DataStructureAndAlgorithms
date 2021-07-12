#include<stdio.h>


int tower_of_honai(int n, int A, int B, int C)
{
    
    if(n>0)
    {
        tower_of_honai(n-1,A,C,B); 
        printf("Tower %d to Tower %d \n", A,C);
        tower_of_honai(n-1,B,A,C);
        
    }
    
}
int main()
{
    tower_of_honai(5,1,2,3);
    return 0;
}