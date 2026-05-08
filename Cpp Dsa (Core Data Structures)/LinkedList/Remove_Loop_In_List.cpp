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
bool checkloop(Node * head,Node * &meetNode){
Node * slowptr=head;
Node * fastptr=head;
while(fastptr && fastptr->next){
    
    slowptr=slowptr->next;
    fastptr=fastptr->next->next;
    if(slowptr==fastptr){
        meetNode=fastptr;
        return 1;
    }
}
return 0;
}
int countloop(Node * head){
Node * slowptr=head;
Node * fastptr=head;
while(fastptr && fastptr->next){
    
    slowptr=slowptr->next;
    fastptr=fastptr->next->next;
    if(slowptr==fastptr){
        slowptr=slowptr->next;
        int count=1;
     while(slowptr!=fastptr){
        slowptr=slowptr->next;
        count++;
       
     }

        return count;


    }
}
return 0;
}

void removeLoopbylength(Node *head,int len){
Node *fastptr=head;
Node *slowptr=head;
while(len){
    fastptr=fastptr->next;
    len--;

}
while(slowptr!=fastptr){
    slowptr=slowptr->next;
    fastptr=fastptr->next;
}
while(slowptr->next!=fastptr){
    slowptr=slowptr->next;
}
slowptr->next=NULL;
}
void removeLoopbyintersection(Node *head,Node * meetNode){
    Node * slowptr=head;
    while(slowptr!=meetNode){
        slowptr=slowptr->next;
        meetNode=meetNode->next;
    }
    while(slowptr->next!=meetNode){
        slowptr=slowptr->next;
    }
    slowptr->next=NULL;
}
int main(){
Node * head = new Node(2);
Node * node1 = new Node(3);
head->next=node1;
Node * node2 = new Node(4);
node1->next=node2;
Node * node3 = new Node(5);
node2->next=node3;
node3->next=node2;
//comment above line to remove loop
Node * meetNode=NULL;
if(checkloop(head,meetNode)){
    cout<<"loop exists"<<endl;
    int len=countloop(head);
    cout<<"length of loop is :"<<len<<endl;
int choice=-1;
cout<<"enter method of removal:\n 1.for by length | 2 for by intersection "<<endl;
cin>>choice;
switch (choice)
{
case 1:
     removeLoopbylength(head,len);
    break;
case 2:
     removeLoopbyintersection(head,meetNode);
 break;
default:
    break;
}
   
   cout<<"list after removing loop "<<endl;
    while(head){
        cout<<head->data<<endl;
        head=head->next;
    }
   
}
else{
        cout<<"loop doesnt exists";
}
return 0;
}