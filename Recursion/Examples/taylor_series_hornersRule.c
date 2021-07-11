#include<stdio.h>

//Note about the recursion, when we decrease the number of multiplication in the equation, time comlepxity 
// will be decrease 

double taylorHorner(int x, int n)
{
    static double s =1;
    if(n==0)
    {
        return s;
    }else
    {
        s= 1+ s/n*x;
    }
    return taylorHorner(x, n-1);
}


int main()
{
   
    printf("%lf ", taylorHorner(2,10));
    return 0;
}