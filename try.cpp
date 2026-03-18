#include<iostream>
using namespace std;
struct Node{
    Node * left;
    Node * right;
    int data;
};
Node* createNode(int data){
    Node * node=new Node;
    node->data=data;
    node->left=NULL;
    node->right=NULL;
    return node;
}
void inorder(Node * root){
if(root==NULL){
    return;
}

inorder(root->left);
cout<<root->data;
inorder(root->right);

}
void preorder(Node * root){
if(root==NULL){
    return;
}
cout<<root->data;
preorder(root->left);

preorder(root->right);

}
void postorder(Node * root){
if(root==NULL){
    return;
}

postorder(root->left);

postorder(root->right);
cout<<root->data;
}
int main(){
    Node * root=createNode(1);
    Node*left=createNode(2);
    Node* right=createNode(3);
    Node*four=createNode(4);
    Node* five=createNode(5);
      Node*six=createNode(6);
    Node* seven=createNode(7);
    root->left=left;
    root->right=right;
    left->left=four;
    left->right=five;
    right->left=six;
    right->right=seven;
    inorder(root);
    cout<<"in order -------"<<endl;
     preorder(root);
    cout<<"in preorder -------"<<endl;
     postorder(root);
    cout<<"in postorder -------"<<endl;
    return 0;

}