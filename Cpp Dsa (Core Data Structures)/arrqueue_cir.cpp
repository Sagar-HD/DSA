#include<iostream>
#include<stdlib.h>
using namespace std;
struct CircularQueue{
    int f;
    int r;
    int * arr;
    int size;
};
int isfull(struct CircularQueue * Q){

    if(((Q->r+1)%(Q->size))==Q->f)
    {
        return 1;

    }else{
        return 0;
    }
}
int isempty(struct CircularQueue * Q){
    if(Q->r==Q->f)
    {
        return 1;
    }else{
        return 0;
    }
}
void enqueue(struct CircularQueue * Q,int val){
if(isfull(Q)){
    cout<<"queue overflow \n";
    return;
}
Q->r=(Q->r+1)%(Q->size);
Q->arr[Q->r]=val;
cout<<val<<" : added to queue \n";

}

void dequeue(struct CircularQueue * Q){
    if(isempty(Q)){
        cout<<"queue underflow \n";
        return;
    }
    Q->f=(Q->f+1)%(Q->size);
   int val = Q->arr[Q->f];
    cout<<val<<" : removed from queue \n";
    }


int main(){

struct  CircularQueue * Q= new CircularQueue;
Q->f=0;
Q->r=0;
Q->size=6;
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
enqueue(Q,1);
enqueue(Q,2);
enqueue(Q,3);
enqueue(Q,4);
enqueue(Q,5);

    return 0;
}
