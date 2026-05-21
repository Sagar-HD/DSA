package Trees.BinaryTree;
import java.util.Scanner;
public class BinaryTree {


    public static class Node{
      public int value;
      public Node left;
      public Node right;
       public Node(int value){
        this.value=value;

       }

    }
    public Node root;
  
public void populate(Scanner scanner){
    System.out.println("enter root value");
    int rootVal=scanner.nextInt();
    Node rootNode=new Node(rootVal);
    this.root=rootNode;
    populate(scanner,rootNode);

}
 void populate(Scanner scanner,Node node){
    if(node!=null){
    System.out.println("Do you want to enter left node for "+node.value);
    boolean left=scanner.nextBoolean();
    if(left){
        System.out.println("enter left value");
        Node leftNode=new Node(scanner.nextInt());
        node.left=leftNode;
        populate(scanner, leftNode);
    }
     System.out.println("Do you want to enter right node for "+node.value);
    boolean right=scanner.nextBoolean();
    if(right){
        System.out.println("enter right value");
        Node rightNode=new Node(scanner.nextInt());
        node.right=rightNode;
        populate(scanner, rightNode);
    }
    }
}
 void display(){
    if(this.root!=null){
       display(this.root,"");
    }

}
 void display(Node node,String indent){
    if(node==null){
        return;
    }
    System.out.print(indent);
    System.out.println(node.value);
    display(node.left,indent+"\t");
    display(node.right,indent+"\t");
}


public static void main(String[] args) {
    BinaryTree binaryTree=new BinaryTree();
    Scanner scanner=new Scanner(System.in);
    binaryTree.populate(scanner);
    binaryTree.display();
}

    
}
