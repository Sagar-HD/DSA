package Trees.BinaryTree.BinaryTreeProblems.DFS.PrimitiveReturnFromChildProblems;

import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;


public class FlattenBinaryTreeToLinkedList {
    //this solution uses time and space complecity in O(N);
    static void flattenUsingQueue(Node root){
        Queue<Node> preOrder=new LinkedList<>();
        getPreOrder(root, preOrder);
        preOrder.poll();
        //removing head bcs not needed in queue
        Node head=root;
        while (!preOrder.isEmpty()) {
            head.right=preOrder.poll();
            head.left=null;
            head=head.right;
        }
        head.left = null;
       head.right = null;
       //last node making childs empty
      

    }
    static void getPreOrder(Node root,Queue<Node> ans){
       if(root==null){
           return ;
        }
        ans.offer(root);
        getPreOrder(root.left, ans);
       getPreOrder(root.right, ans);


    }
   //optimal solution
   /*this is similar to morris preorder traversal but there is no thread bcs 
   we any moving to right always , if left exisits add right node to its right most  node ,
   which is the predecessor of right node in terms of pre order
   then make left as right and move to right
   if you feel confused just see morris traversal code in binarytree traversal file ull get it 
   */
  // this method solves in time and space O(N) and O(1)
    static void flatten(Node node){
        if(node==null){
         return ;
        }
        Node cur=node;
while(cur!=null){
    Node temp=cur.left;
if(temp!=null){
    while(temp.right!=null){
        temp=temp.right;
    }
    temp.right=cur.right;
    cur.right=cur.left;
    cur.left=null;
}
    cur=cur.right;

}
    }
     // this method solves in time  O(N2) because time for nodes processing by right and time to append and right
     //  and space O(H)
     //So use second method 
    public static void flattenRecursive(Node node){
        if(node==null){
         return ;
        }
        if(node.left!=null){
            appendAtRightEnd(node.left, node.right);
            node.right=node.left;
            node.left=null;
        }
        flattenRecursive(node.right);

    }
    static void appendAtRightEnd(Node node,Node nodeToAppend){
        if(node.right==null){
            node.right=nodeToAppend;
            return;
        }
        appendAtRightEnd(node.right, nodeToAppend);

    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6,7};
        bt.populateTree(arr);
        bt.printTree();
        flattenUsingQueue(bt.root);
       // flatten(bt.root);
        //flattenRecursive(bt.root);
        bt.printTree();
        
    }
    
}
