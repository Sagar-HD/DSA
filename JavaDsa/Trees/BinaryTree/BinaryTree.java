package Trees.BinaryTree;
import java.util.Scanner;
public class BinaryTree {


    public static class Node implements TreeNode{
      public int value;
      public Node left;
      public Node right;
      //this field is added  for the purpose of connect node problem only
      public Node next;
       public Node(int value){
        this.value=value;

       }
       @Override
       public TreeNode getLeft() {
        return this.left;
       }
       @Override
       public TreeNode getRight() {
        return this.right;
       }
       @Override
       public int getValue() {
        return this.value;
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
//this methods uses quque to process nodes level wise
//keeps on increments the array index and then keep on adding it in level oder to nodes left and right
public void populateTree(int[] arr){
    if(arr == null || arr.length == 0){
        return;
    }

    this.root = new Node(arr[0]);

    java.util.Queue<Node> queue = new java.util.LinkedList<>();
    queue.offer(this.root);

    int i = 1;

    while(i < arr.length){
        Node current = queue.poll();

        if(i < arr.length){
            current.left = new Node(arr[i++]);
            queue.offer(current.left);
        }

        if(i < arr.length){
            current.right = new Node(arr[i++]);
            queue.offer(current.right);
        }
    }
}
public void printTree() {
    printTree(this.root, 0);
}

public void printTree(Node node, int level) {
    if (node == null) {
        return;
    }

    printTree(node.right, level + 1);

    for (int i = 0; i < level; i++) {
        System.out.print("    ");
    }
    System.out.println(node.value);

    printTree(node.left, level + 1);
}

public static void main(String[] args) {
    BinaryTree binaryTree=new BinaryTree();
    Scanner scanner=new Scanner(System.in);
    binaryTree.populate(scanner);
    binaryTree.display();
}

    
}
