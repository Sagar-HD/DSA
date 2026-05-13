#include<iostream>
#include<stdlib.h>
#include<string>
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
bool isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '{' && close == '}') ||
           (open == '[' && close == ']');
}
void matchpara(string eq){
   struct Stack * Paras = new Stack;
   Paras->size=100;
   Paras->top=-1;
   Paras->arr=(char *)malloc(Paras->size*sizeof(char));
   int i=0;

while(eq[i]!='\0'){
    if(eq[i]=='('||eq[i]=='{'||eq[i]=='['){
   push(Paras,eq[i]);
    }
    else if(eq[i]==')'||eq[i]=='}'||eq[i]==']')
    {
        if(isMatchingPair(Paras->arr[Paras->top],eq[i])){
        int val=pop(Paras);
        if(val==-1){
            cout<<"paranthesis doesnt match underflow\n";
            return;
        }
        }
        else{
            cout<<eq[i]<<"   "<<Paras->arr[Paras->top];
            cout<<"paranthesis doesnt match not balanced\n";
            return;
        }
       
    }

    i++;



    }
if(isempty(Paras)){
    cout<<"paranthesis  matched\n";
}
else{
    cout<<"paranthesis doesnt matched\n";
}
display(Paras);
free(Paras->arr);
free(Paras);
}

int main(){
  string eq="[((5*2)-2{(2-3)})]";
  matchpara(eq);
    return 0;
}