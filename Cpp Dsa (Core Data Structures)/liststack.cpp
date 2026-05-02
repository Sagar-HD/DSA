#include<iostream>
#include<stdlib.h>
using namespace std;
struct Node{
    int data;
    struct Node * next;
};


struct Node * top = NULL;


int isempty(struct Node * top){
    if(top==NULL){
        return 1;
    }
    else{
        return 0;
    }
}
int isfull(struct Node * top){
    struct Node * ptr=new Node;
    if(ptr){
        free(ptr);
        return 0;
    }
    else{
        return 1;
    }
}

void push(struct Node * &top,int val){
    if(isfull(top)){
        cout<<"stack overflow \n";
    }
    else{
      
    struct Node * ptr = new Node;
    ptr->data=val;
    ptr->next=top;
    top=ptr;
        
    cout<<val<<" : pushed to stack\n ";
    }
}

void pop(struct Node * &top){

    if(isempty(top)){
        cout<<"stack underflow \n";
    }
    else{
   struct Node * ptr=top;
   int val= ptr->data;
   top=ptr->next;
    free(ptr);
   
    cout<<val<<" : poped from stack\n";
    }
}


// void peek( struct Node * Sp,int index){
//     if(Sp->top-index+1>=0){
// cout<<"peek value at "<<index<<" is "<<Sp->arr[Sp->top-index+1]<<endl;
//     }
//     else{
//         cout<<"there is no element at :"<<index<<endl;
//     }
// }

void display(struct Node * &top){
   
    struct Node * ptr = top;

    while(ptr!=NULL){
       
        cout<<ptr->data<<" ";
      ptr=ptr->next;
    }
cout<<endl;
   

}
int main(){
   
    push(top,1);
    push(top,2);
    push(top,3);
    push(top,4);
    push(top,5);
    display(top);
//     peek(Sp,1);
//     peek(Sp,2);
//     peek(Sp,3);
//     peek(Sp,4);
//     peek(Sp,5);
    pop(top);
    pop(top);
    pop(top);
    pop(top);
    pop(top);
    pop(top);
    display(top);
   


    return 0;
}