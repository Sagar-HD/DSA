package Trees.BinaryTree.BinaryTreeProblems.DFS.NodeReturningFromChildProblems;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class InvertBinaryTree {
    public static Node invertTreePreOrder(Node root) {
        if(root==null){
            return root;
        }
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
    
            invertTreePreOrder(root.left);
            invertTreePreOrder(root.right);
   
        return root;
        
    }
    public static Node invertTreePostOrder(Node root){
        if(root==null){
            return root;
        }
        Node left=invertTreePostOrder(root.left);
        Node right=invertTreePostOrder(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,5,6,33,5,6,9,4};
        bt.populateTree(arr);
        bt.printTree();
        invertTreePreOrder(bt.root);
        bt.printTree();
        invertTreePostOrder(bt.root);
    
        
    }
}