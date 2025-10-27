#include<iostream>
using namespace std;
class Node{
    public:
    int data;
    Node * next;
   Node(int data){
     this->data = data;   
        this->next = NULL;
}
   
};
bool checkloop(Node * head){
Node * slowptr=head;
Node * fastptr=head;
while(fastptr && fastptr->next){
    
    slowptr=slowptr->next;
    fastptr=fastptr->next->next;
    if(slowptr==fastptr){
        return 1;
    }
}
return 0;
}
int main(){
Node * head = new Node(2);
Node * node1 = new Node(3);
head->next=node1;
Node * node2 = new Node(4);
node1->next=node2;
Node * node3 = new Node(5);
node2->next=node3;
node3->next=node2;//comment this line to remove loop
if(checkloop(head)){
    cout<<"loop exists";
}
else{
        cout<<"loop doesnt exists";
}
return 0;
}