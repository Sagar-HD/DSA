#include<iostream>
using namespace std;

struct node {
    int data;
    struct node* left;
    struct node* right;
};

// Create a new node
struct node* create_node(int data) {
    struct node* ptr = new node;
    ptr->data = data;
    ptr->left = NULL;
    ptr->right = NULL;
    return ptr;
}

// Insert node into BST
struct node* insert(struct node* root, int data) {
    if (root == NULL) {
        return create_node(data);
    }
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else if (data > root->data) {
        root->right = insert(root->right, data);
    }
    return root;
}

// Traversals
void preOrderTraversal(struct node* root) {
    if (root != NULL) {
        cout << root->data << " ";
        preOrderTraversal(root->left);
        preOrderTraversal(root->right);
    }
}

void postOrderTraversal(struct node* root) {
    if (root != NULL) {
        postOrderTraversal(root->left);
        postOrderTraversal(root->right);
        cout << root->data << " ";
    }
}

void inOrderTraversal(struct node* root) {
    if (root != NULL) {
        inOrderTraversal(root->left);
        cout << root->data << " ";
        inOrderTraversal(root->right);
    }
}

// Check if tree is BST
int isbst(struct node* root, struct node*& prev) {
    if (root != NULL) {
        if (!isbst(root->left, prev)) return 0;
        if (prev != NULL && root->data <= prev->data) return 0;
        prev = root;
        return isbst(root->right, prev);
    }
    return 1;
}


struct node* serachbst(struct node * root,int data){
if(root==NULL){
    return NULL;
}
if(root->data==data)
{
    return root;
}
else if(root->data>data){
    return serachbst(root->left,data);
}
else{
    return serachbst(root->right,data);
}
}

struct node* serachbstfor(struct node * root,int data){
  

  struct node * ptr=root;

while( ptr!=NULL && ptr->data!=data ){
    if(data<root->data){
ptr=ptr->left;
    }else {
ptr=ptr->right;
    }
    
  
}

    return ptr;
  
    }
// Main
int main() {
    struct node* root = NULL;

    // Insert elements to build a larger BST
    int values[] = {10, 5, 20, 3, 7, 15, 25};
    for (int val : values) {
        root = insert(root, val);
    }

    cout << "PreOrder: ";
    preOrderTraversal(root);
    cout << "\nPostOrder: ";
    postOrderTraversal(root);
    cout << "\nInOrder: ";
    inOrderTraversal(root);
    cout << "\n";

    struct node* prev = NULL;
    cout << "Is BST? " << isbst(root, prev) << "\n";
struct node *n=serachbstfor(root,20);
if(n!=NULL){
cout<<"element found : "<<n->data<<endl;
}
else{
  cout<<"element not found :"   ;
}
    return 0;
}
