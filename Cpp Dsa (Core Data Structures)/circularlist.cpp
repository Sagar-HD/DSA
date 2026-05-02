#include <iostream>
#include <stdlib.h>
using namespace std;

struct Node
{
    int data;
    struct Node *next;
};

void display(struct Node *head)
{

    struct Node *ptr = head;

  
    do{

        cout << ptr->data << " -> ";
        ptr = ptr->next;
    } while (ptr != head);



    cout<<"NULL";
    cout << endl;
}

struct Node *inserthead(struct Node *head, int data)
{
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    if (head != NULL)
    {
        ptr->data = data;
        ptr->next = head;
        head = ptr;

        return head;
    }
    else
    {
        ptr->data = data;
        ptr->next = NULL;
        return ptr;
    }
}
struct Node *insertend(struct Node *head, int data)
{
    struct Node *itr = head;
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    ptr->data = data;
    ptr->next = NULL;

    if (head == NULL)
    {

        return ptr;
    }

    while (itr->next != NULL)
    {

        itr = itr->next;
    }
    itr->next = ptr;

    return head;
}

struct Node *insertbetween(struct Node *head, int index, int data)
{
    if (index < 0)
    {
        cout << "invalid index" << endl;
        return head;
    }

    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    if (index == 0)
    {
        ptr->next = head;
        ptr->data = data;
        return ptr;
    }

    struct Node *prev = head;
    int count = 0;
    while (prev != NULL && count < index - 1)
    {
        prev = prev->next;
        count++;
    }

    if (prev == NULL)
    {
        cout << "Index out of bounds.\n";
        free(ptr);
        return head;
    }

    ptr->next = prev->next;
    ptr->data = data;
    prev->next = ptr;

    return head;
}

struct Node *deletehead(struct Node *head)
{
    struct Node *ptr = head;
    struct Node *itr = head;
 do{
    itr=itr->next;
    cout<<itr->next<<endl;

 }while(itr->next!=head);
 
     cout<<"last node:  "<<itr->data<<endl;
    head = head->next;
    itr->next=head;
   
    free(ptr);

    return head;
}
struct Node *deleteatindex(struct Node *head,int index)
{
   struct Node * p=head;
   struct Node * q=head->next;
   for(int i=0;i<index-1;i++)
   {
p=p->next;
q=q->next;
   }
   p->next=q->next;
   free(q);
    return head;
}
struct Node *deleteatend(struct Node *head)
{
   struct Node * p=head;
   struct Node * q=head->next;
  while(q->next!=NULL)
   {
p=p->next;
q=q->next;
   }
   p->next=NULL;
   free(q);
    return head;
}
struct Node *deletebyvalue(struct Node *head,int value)
{
   struct Node * p=head;
   struct Node * q=head->next;
  while(q->data!=value && q->next!=NULL )
   {
p=p->next;
q=q->next;
   }
   if(q->data==value)
   {
   p->next=q->next;
   free(q);
   }else{
    cout<<"element not found";
   }
    return head;
}

int main()
{

   struct Node * head = new Node;
   struct Node * second = new Node;
   struct Node * third = new Node;
   struct Node * fourth = new Node;


   head->data=1;
   head->next=second;
   second->data=2;
   second->next=third;
   third->data=3;
   third->next=fourth;
   fourth->data=4;
   fourth->next=head;
   display(head);
    head=deletehead(head);
   display(head);

        return 0;
   
   
    }
