#include<iostream>
#include<stdlib.h>
#include<string>
#include<vector>
using namespace std;

struct Stack{
    int size;
    int top;
    char * arr;
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

void push(struct Stack * Sp,char val){
    if(isfull(Sp)){
        cout<<"stack overflow \n";
    }
    else{
    Sp->top++;
    Sp->arr[Sp->top]=val;
    cout<<val<<" : pushed to stack\n";
    }
}

char pop(struct Stack * Sp){
    if(isempty(Sp)){
        cout<<"stack underflow \n";
        return -1;
    }
    else{
   
   char val= Sp->arr[Sp->top];
    Sp->top--;
    cout<<val<<" : poped from stack\n";
    return val;
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
int precedence(char ch){
    if(ch=='*'||ch=='/'){
    return 3;}
    else if(ch=='+'||ch=='-'){
    return 2;}
    else {
    return 0;
    }
    }
void iftopf(string eq){
   struct Stack * Paras = new Stack;
   Paras->size=100;
   Paras->top=-1;
   Paras->arr=(char *)malloc(Paras->size*sizeof(char));
   int i=0;
   int j=0;
   char pos[100];

while(eq[i]!='\0'){
    if(eq[i]=='*'||eq[i]=='/'||eq[i]=='-'||eq[i]=='+'){
     
       if(precedence(eq[i])>precedence(Paras->arr[Paras->top])) 
       {
        push(Paras,eq[i]);
        i++;
       }
       else{
       char val= pop(Paras);
       pos[j]=val;
       j++;
       }
     
    
    }
    else if(isalnum(eq[i])){
        pos[j]=eq[i];
        j++;
        i++;
      
    }
}
  while(!isempty(Paras))
  {
    char val=pop(Paras);
    pos[j]=val;
    j++;
  }

pos[j]='\0';

cout<<pos;
   

}

int main(){
  string eq="x+y*z-4/5";
  iftopf(eq);
    return 0;
}