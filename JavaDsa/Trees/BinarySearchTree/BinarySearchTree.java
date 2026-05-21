package Trees.BinarySearchTree;

public class BinarySearchTree {
    private Node root;

    private static class Node {
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value) {
            this.value = value;
            this.height=0;
        }

    }

    public void insert(int value) {
      this.root=insert(root, value);

    }

    public Node insert(Node node, int value) {

        if (node == null) {
            System.out.println("inserted");
            Node newNode = new Node(value);

            return newNode;

        }
        // if less than val go left
        if (value <= node.value) {
            node.left = insert(node.left, value);

        }
        // if greater than val go right
        else {
            node.right = insert(node.right, value);

        }

        // height setting while comming back
        int leftHeight=this.height(node.left);
        int rightHeight=this.height(node.right);
        node.height=1+Math.max(leftHeight, rightHeight);
        return node;
    }
   public int height(Node node){
    if(node==null){
        return -1;
    }
    return node.height;
   }
    public void display() {
        if (root == null) {
            System.out.println("tree is empty");
            return;
        }
        display(root, "root");

    }

    public void display(Node node, String info) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        System.out.print("height :"+node.height);
        System.out.println(info);
        display(node.left, " left child of :" + node.value);
        display(node.right, " right child of :" + node.value);
    }
    public boolean balanced(){
        return balanced(root);
    }
    public boolean balanced(Node node){
        if(node==null){
          
            return true;
        }
        return Math.abs(this.height(node.right)-this.height(node.left))<=1 && balanced(node.left) && balanced(node.right);
    }
    public void populateTree(int[] nums){
        for(int i:nums){
            this.insert(i);
        }
    }
    public void populateSorted(int[] sortedArray){
        populateSorted(sortedArray,0,sortedArray.length-1);

    }
 public void populateSorted(int[] sortedArray,int start,int end){
    if(start>end){
        return;
    }
    int mid=start+(end-start)/2;
    this.insert(sortedArray[mid]);
    this.populateSorted(sortedArray,start,mid-1);
    this.populateSorted(sortedArray,mid+1,end);
        
    }
    //inorder traversal of binary search tree is always sorted
       public static void inOrder(BinarySearchTree tree){
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
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
      
        bst.insert(50);
        bst.insert(30);
    
        bst.insert(60);
          
        bst.insert(20);
        bst.insert(40);
       
        bst.display();
        // poplulating using array
        int[] arr={20,30,40,90};
        BinarySearchTree bst2=new BinarySearchTree();
        bst2.populateTree(arr);
        bst2.display();
        //in this case tree is same as linked list O(n) time to operations
        //this is the main reason to make balanced bst
        BinarySearchTree bst3=new BinarySearchTree();
        bst3.populateSorted(arr);
      System.out.println( bst3.balanced()); 
        bst3.display();
         //inorder traversal of binary search tree is always sorted
        BinarySearchTree.inOrder(bst);
        
    }

}