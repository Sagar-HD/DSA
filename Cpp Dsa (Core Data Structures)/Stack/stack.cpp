#include<iostream>
#include<stdlib.h>
using namespace std;
struct Stack{
    int size;
    int top;
    int * arr;
};
int isempty(struct Stack * Sp){
    if(Sp->top<0){
        return 1;
    }
    else{
        return 0;
    }
}
int isfull(struct Stack * Sp){
    if(Sp->top>=Sp->size-1){
        return 1;
    }
    else{
        return 0;
    }
}

void push(struct Stack * Sp,int val){
    if(isfull(Sp)){
        cout<<"stack overflow \n";
    }
    else{
    Sp->top++;
    Sp->arr[Sp->top]=val;
    cout<<val<<" : pushed to stack\n";
    }
}

void pop(struct Stack * Sp){
    if(isempty(Sp)){
        cout<<"stack underflow \n";
    }
    else{
   
   int val= Sp->arr[Sp->top];
    Sp->top--;
    cout<<val<<" : poped from stack\n";
    }
}


void peek( struct Stack * Sp,int index){
    if(Sp->top-index+1>=0){
cout<<"peek value at "<<index<<" is "<<Sp->arr[Sp->top-index+1]<<endl;
    }
    else{
        cout<<"there is no element at :"<<index<<endl;
    }
}
void display(struct Stack * Sp){
    for(int i=Sp->top;i>=0;i--){
    cout<<Sp->arr[i]<<" ";
    }

}
int main(){
    struct Stack * Sp = new Stack;
    Sp->size=4;
    Sp->top=-1;
    Sp->arr=(int *)malloc(Sp->size*sizeof(int));
    push(Sp,1);
    push(Sp,2);
    push(Sp,3);
    push(Sp,4);
    push(Sp,5);
    peek(Sp,1);
    peek(Sp,2);
    peek(Sp,3);
    peek(Sp,4);
    peek(Sp,5);
    pop(Sp);
    pop(Sp);
    pop(Sp);
    pop(Sp);
    pop(Sp);
   
display(Sp);

    return 0;
}