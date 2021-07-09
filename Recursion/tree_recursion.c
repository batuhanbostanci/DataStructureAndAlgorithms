#include <stdio.h>
//If the method calling it self more than 1 time. That is called tree recursion. 
void method(int n)
{   
    if(n>0)
    {
        printf("%d ", n);
         method(n-1);
         method( n-1);
    }
    
}


int main()
{
    method(3); 
    return 0;
}