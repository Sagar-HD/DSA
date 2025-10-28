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

int intersection(Node *head1,Node * head2){
Node * ptr1=head1;
Node * ptr2=head2;
int count1=0,count2=0;
while(ptr1){
    count1++;
    ptr1=ptr1->next;
}
while(ptr2){
    count2++;
    ptr2=ptr2->next;
}
ptr1=head1;
ptr2=head2;
int steps=0;
if(count1>count2){
steps=count1-count2;
while(steps--){
ptr1=ptr1->next;
}
while(ptr1!=ptr2){
    ptr1=ptr1->next;
    ptr2=ptr2->next;
}
return ptr1->data;
}
else{
steps=count2-count1;
if(steps=0){
    return -1;
}
while(steps--){
ptr2=ptr2->next;
}
while(ptr1!=ptr2){
    ptr1=ptr1->next;
    ptr2=ptr2->next;
}
return ptr1->data;
}
}

int main(){
Node * head1 = new Node(2);
Node * node1 = new Node(3);
head1->next=node1;
Node * node2 = new Node(4);
node1->next=node2;
Node * node3 = new Node(5);
node2->next=node3;
Node * node4 = new Node(6);
node3->next=node4;
Node * head2 = new Node(4);
head2->next=node3;
cout<<"list intersects a value :"<<intersection(head1,head2)<<endl;
return 0;
}