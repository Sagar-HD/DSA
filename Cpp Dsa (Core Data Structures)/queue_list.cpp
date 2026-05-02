#include<iostream>
#include<stdlib.h>
//both queue and double ended queue
using namespace std;
struct node{
    int data;
    struct node * next;
};
struct node * f =NULL ;
struct node * r =NULL ;

int isempty(){
    if(f==NULL)
    {
        return 1;
    }
    else{
        return 0;
    }
}
int isfull(){
    struct node * ptr=new node;
    if(ptr==NULL)
    {   delete ptr;
        return 1;
    }
    else{
         delete ptr;
        return 0;
    }
   
}


void display()
{

    struct node *ptr = f;

    while (ptr != NULL)
    {

        cout << ptr->data << " -> ";
        ptr = ptr->next;
    }
    cout << endl;
}




void enqueue(int val){
if(isfull()){
    cout<<"queue is full \n";
}
else{
    struct node * ptr=new node;
    ptr->data=val;
    ptr->next=NULL;
    if(f==NULL){
f=r=ptr;
    }
    else{
        r->next=ptr;
        r=ptr;
    }
  
}
}
void enqueuef(int val){
    if(isfull()){
        cout<<"queue is full \n";
    }
    else{
        struct node * ptr=new node;
        ptr->data=val;
    
        if(f==NULL){
    f=r=ptr;
    ptr->next=NULL;
        }
        else{

          ptr->next=f;
            f=ptr;
        }
    }
    }



int dequeue(){
    if(isempty()){
        cout<<"queue is empty \n";
        return -1;
    }
    else{
        struct node * ptr=f;
       f=f->next;
    int val=ptr->data;
    delete ptr;
     
      return val;
        
    }
    }

    void dequeuer(){
        if(isempty()){
            cout<<"queue is empty \n";
        }
        else{
            struct node * ptr=f;
            struct node * ptr1=f->next;
            
            while(ptr1->next!=NULL){
                ptr=ptr->next;
                ptr1=ptr1->next;
            }
           ptr->next=NULL;
        int val=ptr1->data;
        delete ptr1;
          cout<<val<<" : deleted from queue \n";
            
        }
        }


int main()
{
    // enqueue(2);
    // enqueue(3);
    // enqueue(4);
    // display();
    // dequeue();
    // dequeue();
    // dequeue();
    // dequeue();
    // enqueue(5);
    // enqueue(6);
    // enqueue(7);
    // dequeuer();
    // display();
    // enqueuef(4);
    // display();
  
int visited[7]={0,0,0,0,0,0,0};
int graph[7][7] = {
    {0, 1, 1, 0, 0, 0, 0},
    {1, 0, 0, 1, 1, 0, 0},
    {1, 0, 0, 0, 0, 1, 0}, 
    {0, 1, 0, 0, 0, 0, 1}, 
    {0, 1, 0, 0, 0, 0, 0}, 
    {0, 0, 1, 0, 0, 0, 1}, 
    {0, 0, 0, 1, 0, 1, 0}  
};
int source=2;
visited[source]=1;
enqueue(source);

while(!isempty()){
    int j=dequeue();
   
  cout<<j<<" \n";
for(int i=0;i<7;i++)
{
    if(graph[j][i]==1 && visited[i]!=1 ){
visited[i]=1;
enqueue(i);
    }

}
  
}
  return 0;
}