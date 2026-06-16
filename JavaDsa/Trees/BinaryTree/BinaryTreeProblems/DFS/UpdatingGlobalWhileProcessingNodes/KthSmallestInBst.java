package Trees.BinaryTree.BinaryTreeProblems.DFS.UpdatingGlobalWhileProcessingNodes;

import Trees.BinarySearchTree.BinarySearchTree.Node;
//inorder traversal to get kth smallest number
//to get sorted array in bst we do inorder traversal 
//same way after going to leftmost we start increasing count after traversing each node
//if we already found k th element in left then we return that //if its null
//check count ==k we stop traversing and start returning it to the parent
//else go to right side of node to traverse
public class KthSmallestInBst {
   static int count=0;
    public static Node get(Node node,int k){

        if(node==null){
            return null;
        }
        Node left=get(node.left,k);
        if(left!=null){
            return left;
        }
        count++;
       if(count==k){
        return node;
       }
       return get(node.right, k);
      
    }
   public static void main(String[] args) {

    /*
              5
            /   \
           3     7
          / \   / \
         2   4 6   8

        Inorder: 2 3 4 5 6 7 8
    */

    Node root = new Node(5);
    root.left = new Node(3);
    root.right = new Node(7);

    root.left.left = new Node(2);
    root.left.right = new Node(4);

    root.right.left = new Node(6);
    root.right.right = new Node(8);

    for (int k = 1; k <= 7; k++) {
        count = 0; // reset before each call

        Node ans = get(root, k);

        if (ans != null) {
            System.out.println("k = " + k + " -> " + ans.value);
        } else {
            System.out.println("k = " + k + " -> null");
        }
    }

    // Invalid k
    count = 0;
    Node ans = get(root, 10);
    System.out.println("k = 10 -> " + (ans == null ? "null" : ans.value));
}
    
}
