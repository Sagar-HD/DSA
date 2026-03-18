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

    while (ptr != NULL)
    {

        cout << ptr->data << " -> ";
        ptr = ptr->next;
    }
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
    head = head->next;
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

    struct Node *head = NULL;
    int selection;
    int choice;
    int num;
    while (1)
    {

      
            cout << "select the opertaion you want to perform \n 1. for insertion at head or new add \n 2. for insertion in between \n 3. for insertion at end \n 4. for deletion at head  \n 5. for deletion in index \n 6. for deletion at end \n 7. deletion by value  \n 8. for display   \n 9. to exit \n ";
            cin >> choice;
            switch (choice)
            {
            case 1:
                cout << "enter the number \n";
                cin >> num;
                head = inserthead(head, num);
                break;
            case 2:
                cout << "enter the number \n";
                cin >> num;
                cout << "enter the index \n";
                int i;
                cin >> i;
                head = insertbetween(head, i, num);
                break;
            case 3:
                cout << "enter the number \n";
                cin >> num;
                head = insertend(head, num);
                break;
            case 4:
                head=deletehead(head);

                break;
            case 5:
            cout << "enter the index \n";
            cin >> i;
            head=deleteatindex(head,i);
                break;
            case 6:
head=deleteatend(head);
                break;
            case 7:
            cout << "enter the number \n";
            cin >> num;
               head=deletebyvalue(head,num);
          
                break;
            case 8:
                display(head);

                break;
            case 9:
                return 0;
                break;

            default:
                cout << "invalid option\n";
            }
        }

        return 0;
    }
