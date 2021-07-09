#include<stdio.h>



double taylor(int x, int n)
{
    static  double numerator=1, denumerator = 1;
    double temp;

    if(n==0)
    {
        return 1;
    }
    else
    {
      
        temp = taylor(x,n-1);
        numerator=x* numerator;
        denumerator = denumerator*n;
        return temp + numerator/denumerator;
    }
}


int main()
{
   
    printf("%lf ", taylor(4,10));
    return 0;
}