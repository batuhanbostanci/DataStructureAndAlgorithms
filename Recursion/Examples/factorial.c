#include<stdio.h>


int factorial(int number)
{
    if(number==0)
    {
        return 1;
    }
    if(number ==1)
    {
        return 1;
    } 
    else
    {
        return factorial(number-1)*number;
    }
}

int main()
{
    int t;
    t= factorial(5);
    printf("%d ", t);
    return 0;
}