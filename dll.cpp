#include<iostream>
using namespace std;
class Node{
    public:
    int data;
     Node * prev;
    Node * next;
    Node(int val){
        data=val;
        prev=NULL;
        next=NULL;
    }
};
Node * Dll(int arr[],int n,int index,Node *head){
    if(index==n){
   
        return NULL;
    }
    if(head==NULL){
    Node *temp=new Node(arr[index]);
 
    head=temp;

    }
    else{
            Node *temp=new Node(arr[index]);
            temp->prev=head;
            head=temp;

    }
    head->next=Dll(arr,n,index+1,head);
    return head;
}
int main(){
   int arr[4]={10,20,30,40};
Node * head=NULL;
head=Dll(arr,4,0,head);
while(head){
    cout<<head->data;
    head=head->next;

}
    return 0;
}