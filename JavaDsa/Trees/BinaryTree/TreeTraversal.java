package Trees.BinaryTree;

import java.util.Scanner;


import Trees.BinaryTree.BinaryTree.Node;

public class TreeTraversal {
    
      public static void preOrder(BinaryTree tree){
        if(tree!=null){
helperPreOrder(tree.root);
        }

    }
    public static void helperPreOrder(Node node){
if(node==null){
    return;
}
System.out.println(node.value);
helperPreOrder(node.left);
helperPreOrder(node.right);
    }


    public static void inOrder(BinaryTree tree){
          if(tree!=null){
helperInOrder(tree.root);
        }

    }
      public static void helperInOrder(Node node){
if(node==null){
    return;
}

helperInOrder(node.left);
System.out.println(node.value);
helperInOrder(node.right);
    }


      public static void postOrder(BinaryTree tree){
  if(tree!=null){
helperPostOrder(tree.root);
        }
    }
     public static void helperPostOrder(Node node){
if(node==null){
    return;
}

helperPostOrder(node.left);

helperPostOrder(node.right);
System.out.println(node.value);
    }
    
    public static void main(String[] args) {
     BinaryTree binaryTree=new BinaryTree();
     binaryTree.populate(new Scanner(System.in));
     System.out.println("pre order traversal");
     TreeTraversal.preOrder(binaryTree);
       System.out.println("in order traversal");
     TreeTraversal.inOrder(binaryTree);
       System.out.println("post order traversal");
     TreeTraversal.postOrder(binaryTree);

    }
    
}
