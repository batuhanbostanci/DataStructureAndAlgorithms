#include<stdio.h>


int fibonnaci(int n)
{
    if(n<=1)
    {
        return n;
    }
    else
    {
    return fibonnaci(n-2) + fibonnaci(n-1);
    }
}
//in this recursion type, some of the terms calls it again in the recursive method. 
//Those are called Exessive recurions, for these one we are going to develop method to reduce time complextiy.

//In such cases, we can use memoziations with these way if we keep the elements inside array, when we need 
//recall the method we can just look at the array

int F[100];
int fibonnaci_memoziation(int n)
{
    if(n<=1)
    {
        F[n]=n;
        return n;
    }
    else
    {
    if(F[n-2]==-1)
    {
        F[n-2] = fibonnaci_memoziation(n-2);
    }
    
    if(F[n-1]==-1)
    {
        F[n-1] = fibonnaci_memoziation(n-1);
    }
    return F[n-2] +F[n-1];
    }
}

int main()
{
    int i;
    for(i=0;i<=100;i++)
    {
        F[i]=-1;
    }

   printf("%d \n",  fibonnaci(5));
   printf("%d",  fibonnaci_memoziation(5));
    return 0;
}