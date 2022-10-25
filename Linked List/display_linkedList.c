#include <stdlib.h>
#include <stdio.h>

struct Node{
    int data;
    struct Node *next;
}*first=NULL;

void create_linked_list(int A[], int n){
    
    struct Node *t,*last;
    first = (struct Node *)malloc(sizeof(struct Node));
    first ->data = A[0];
    first->next = NULL;
    last = first;

    int i;
    for(i=1;1<n;i++){
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = NULL;
        last->next = t;
        
    }

}

int main(){

    int A[] = {3,5,7,10,15};

    return 0;
}