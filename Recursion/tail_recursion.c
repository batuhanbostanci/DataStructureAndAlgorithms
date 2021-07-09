#include <stdio.h>
//If the recursive statment is in the end of the method that means this is tail recursion, below example is good example 
// for tail recursion but if we have statement like return method(n-1) + n 
// In such cases plus (+n) adding while returning time not in the executing time 


// Time is O(n) in terms of space loops is better for tail recursion becasue loop takes O(1) space but tail recursion
// takes O(n) space  
void method(int n)
{   
    if(n>0)
    {
        printf("%d ", n);
         method(n-1);
    }
    
}
//
//OR
/*
return method1(int n)
{
    if(n>0)
    {
        printf("%d ", n);
       return method1(n-1) +n;
    }
   return -1;
}
*/

int main()
{
    method(3); 
    return 0;
}