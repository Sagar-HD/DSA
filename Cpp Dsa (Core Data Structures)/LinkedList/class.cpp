#include<iostream>
using namespace std;
// class car{
    
//     string color;
//     public:
//     void setcolor(string c){
//         if(c=="pink"){
// cout<<"color not allowed";
// return;
//         }
//         color=c;
//     }
//     string getcolor(){
//         return color;
//     }

// };
class Node{
    public:
    int data;
    Node * next;
    Node(int val){
        data=val;
        next=NULL;
    }
};
Node* createLinkedList(int arr[],int n,int index=0){
    if(index==n){
        return NULL;
    }
   
    
  Node * head=new Node(arr[index]);
    head->next=createLinkedList(arr,n,index+1);
  

return head;
}
int main(){
    // car swift;
    // string color;
    // cout<<"enter color";
    // cin>>color;
    // swift.setcolor(color);
    // cout<<swift.getcolor();
   int arr[5]={1,2,3,4,5};
   Node * head=NULL;
   
head=createLinkedList(arr,5);
//    for(int i=0;i<5;i++){
//    if(head==NULL){
//     head=new Node(arr[i]);
//     tail=head;

//    }
//    else{
     
//     tail->next=new Node(arr[i]);
//     tail=tail->next;

//    }
// }

while(head!=NULL){
    cout<<head->data<<" ";
    head=head->next;
}
    return 0;
}