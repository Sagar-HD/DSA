#include<iostream>
#include<stdlib.h>
using namespace std;
struct Queue{
    int f;
    int r;
    int * arr;
    int size;
};
int isfull(struct Queue * Q){
    if(Q->r>=Q->size-1)
    {
        return 1;
    }else{
        return 0;
    }
}
int isempty(struct Queue * Q){
    if(Q->r==Q->f)
    {
        return 1;
    }else{
        return 0;
    }
}
void enqueue(struct Queue * Q,int val){
if(isfull(Q)){
    cout<<"queue overflow \n";
    return;
}
Q->r++;
Q->arr[Q->r]=val;
cout<<val<<" : added to queue \n";
}

void dequeue(struct Queue * Q){
    if(isempty(Q)){
        cout<<"queue underflow \n";
        return;
    }
    Q->f++;
   int val = Q->arr[Q->f];
    cout<<val<<" : removed from queue \n";
    }


int main(){

struct  Queue * Q= new Queue;
Q->f=Q->r=-1;
Q->size=5;
Q->arr=(int *)malloc(Q->size*sizeof(int));
enqueue(Q,1);
enqueue(Q,2);
enqueue(Q,3);
enqueue(Q,4);
enqueue(Q,5);
enqueue(Q,6);
dequeue(Q);
dequeue(Q);
dequeue(Q);
dequeue(Q);
dequeue(Q);
dequeue(Q);
enqueue(Q,7);
    return 0;
}
