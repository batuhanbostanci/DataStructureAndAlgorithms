#include <stdio.h>
//If the method calling it self more than 1 time. That is called tree recursion. 
int method(int n)
{   
    if(n>100)
    {
        return n-10;
    }
    else
    {
        return method(method(n+11));
    }
}


int main()
{
    printf("%d ", method(95)); 
    return 0;
}