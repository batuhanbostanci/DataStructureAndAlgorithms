#include <stdio.h>
//Same with tail recursion but the idea is it has to do while returning time 
void method(int n)
{   
    if(n>0)
    {
        printf("%d ", n);
         method(n-1);
    }
    
}


int main()
{
    method(3);
    return 0;
}