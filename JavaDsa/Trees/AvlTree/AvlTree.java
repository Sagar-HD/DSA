package Trees.AvlTree;

public class AvlTree {
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
        // if less than val go left ... duplicates also go to left
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

        //this rotate function makes sure that its balanced
        return rotate(node);
    }

 public Node rotate(Node node){
    //left heavy bcs left - right is positive and greater than 1
  if(this.height(node.left)-this.height(node.right)>=2){
// We got to know left side has more 
//  but now it also have 2 branches
//  we need to check which direction tree is growing more
//we need to check which side the imbalance is going 

//if below condition satisfies
//imbalance becomes LEFT LEFT
// left has more height and we just need 1 right rotation to fix this 
//imbalance is going to left side of left

    if(height(node.left.left)>=height(node.left.right)){
        return rightRotate(node);

    }
//if below condition satisfies
//imbalance becomes LEFT RIGHT
// then right of left has more height and we first need left  rotation to node.left and then right rotation to node  to fix this 
//imbalance is going to right side of left

    else{
      node.left=leftRotate(node.left);
      return rightRotate(node);

    }




  }
  //right heavy bcs left - right is negative and lesser than -1
  if(height(node.left)-height(node.right)<=-2){
// We got to know rightt side has more 
//  but now it also have 2 branches
//  we need to check which direction tree is growing more
//we need to check which side the imbalance is going 

//if below condition satisfies
//imbalance becomes RIGHT LEFT
// left is more . we first need right  rotation to node.right  and then left rotation to node  to fix this 
//imbalance is going to left side of Right

    if(height(node.right.left)>=height(node.right.right)){
        node.right=rightRotate(node.right);
        return leftRotate(node);

    }
//if below condition satisfies
//imbalance becomes RIGHT RIGHT
// then right of right has more height and we one left rotation to node to fix this
//imbalance is going to right side of right

    else{
    
      return leftRotate(node);

    }






  }
//if its balanced means height diffrence is not 0 1 or -1 then its balanced return same node 
    return node;
 }

public Node leftRotate(Node parent){
Node child=parent.right;
//preserving left subtree in temp before making it as the node we are moving
Node temp=child.left;
child.left=parent;
parent.right=temp;

    // update heights
    parent.height = 1 + Math.max(height(parent.left), height(parent.right));
    child.height = 1 + Math.max(height(child.left), height(child.right));

return child;
}
public Node rightRotate(Node parent){
Node child=parent.left;
//preserving right subtree in temp before making it as the node we are moving
Node temp=child.right;

child.right=parent;
parent.left=temp;
    
    // update heights
    parent.height = 1 + Math.max(height(parent.left), height(parent.right));
    child.height = 1 + Math.max(height(child.left), height(child.right));
    
return child;
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
   
    public static void main(String[] args) {
        AvlTree avlTree=new AvlTree();
        int[] arr={10,20,30,40};
        avlTree.populateTree(arr);
        avlTree.display();
        System.out.println(avlTree.balanced());

        AvlTree avlTree2=new AvlTree();
        for(int i=0;i<1000;i++){
            avlTree2.insert(i);
        }
        System.out.println(avlTree2.height(avlTree2.root));
       
        
    }

}