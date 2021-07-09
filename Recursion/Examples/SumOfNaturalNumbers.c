#include<stdio.h>


int method_add(int number)
{
    if(number==0)
    {
        return 0;
    }
    else
    {
      return method_add(number-1) + number;
    }
}

int main()
{
    int t;
    t= method_add(5);
    printf("%d ", t);
    return 0;
}