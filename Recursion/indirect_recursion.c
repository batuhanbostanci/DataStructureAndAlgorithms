#include <stdio.h>
//In indricet recursion, there are lot's of recursion in the methods. I mean when i used a method there is
// another recursion in that method. This called indirect recursion 
void method_B(int n);

void method_A(int n)
{   
    if(n>0)
    {
        printf("%d ", n);
         method_B(n-1);
    }
    
}
void method_B(int n)
{   
    if(n>1)
    {
        printf("%d ", n);
         method_A(n/2);
    }
    
}
int main()
{
    method_A(20); 
    return 0;
}