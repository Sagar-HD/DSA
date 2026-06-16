package Trees.BinaryTree.BinaryTreeProblems.DFS.NodeReturningFromChildProblems;

import java.util.Arrays;
import java.util.HashMap;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class ConstructBinaryTreeFromPreAndInOrder {
   public static Node buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        int root=preorder[0];
        int index=0;
        while(inorder[index]!=root){
            index++;
        }
        Node node=new Node(root);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
        return node;
        
    }
    // now instead of looping over inorder to find index we are using hashmap
    // and instead od copying whole array for space optimization and time optimization we pass left and right index
    //pre order index is primitive so just using array with one element to store index
    public static Node buildTree2(int[] preorder, int[] inorder,int left,int right,int[] preorderIndex,HashMap<Integer,Integer> indexMap){
        if(left>right){
            return null;
        }
        int current=preorder[preorderIndex[0]];
        preorderIndex[0]++;
        Node node=new Node(current);
        int inorderCurrentNodeIndex=indexMap.get(current);
        node.left=buildTree2(preorder,inorder,left,inorderCurrentNodeIndex-1,preorderIndex,indexMap);
        node.right=buildTree2(preorder,inorder,inorderCurrentNodeIndex+1,right,preorderIndex,indexMap);
        return node;

    }

   public static void main(String[] args) {

    // Test Case 1
    int[] preorder1 = {3, 9, 20, 15, 7};
    int[] inorder1 = {9, 3, 15, 20, 7};

    Node root1 = buildTree(preorder1, inorder1);

    System.out.println("Test Case 1");
    System.out.println("Root: " + root1.value);                    // 3
    System.out.println("Left Child: " + root1.left.value);         // 9
    System.out.println("Right Child: " + root1.right.value);       // 20
    System.out.println();

    // Test Case 2: Single Node
    int[] preorder2 = {1};
    int[] inorder2 = {1};

    Node root2 = buildTree(preorder2, inorder2);

    System.out.println("Test Case 2");
    System.out.println("Root: " + root2.value);                    // 1
    System.out.println();

    // Test Case 3: Left Skewed Tree
    int[] preorder3 = {1, 2, 3, 4};
    int[] inorder3 = {4, 3, 2, 1};

    Node root3 = buildTree(preorder3, inorder3);

    System.out.println("Test Case 3");
    System.out.println("Root: " + root3.value);                    // 1
    System.out.println("Root.left: " + root3.left.value);          // 2
    System.out.println("Root.left.left: " + root3.left.left.value);// 3
    System.out.println();

    // Test Case 4: Right Skewed Tree
    int[] preorder4 = {1, 2, 3, 4};
    int[] inorder4 = {1, 2, 3, 4};

    Node root4 = buildTree(preorder4, inorder4);

    System.out.println("Test Case 4");
    System.out.println("Root: " + root4.value);                     // 1
    System.out.println("Root.right: " + root4.right.value);         // 2
    System.out.println("Root.right.right: " + root4.right.right.value); // 3
    System.out.println();

    // Test Case 5: Complete Binary Tree
    int[] preorder5 = {1, 2, 4, 5, 3, 6, 7};
    int[] inorder5 = {4, 2, 5, 1, 6, 3, 7};

    Node root5 = buildTree(preorder5, inorder5);

    System.out.println("Test Case 5");
    System.out.println("Root: " + root5.value);                    // 1
    System.out.println("Left Child: " + root5.left.value);         // 2
    System.out.println("Right Child: " + root5.right.value);       // 3
    System.out.println("Left.Left: " + root5.left.left.value);     // 4
    System.out.println("Left.Right: " + root5.left.right.value);   // 5
    System.out.println("Right.Left: " + root5.right.left.value);   // 6
    System.out.println("Right.Right: " + root5.right.right.value); // 7value
    
    //testing second method 
    HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < inorder1.length; i++) {
    map.put(inorder1[i], i);
}

Node root = buildTree2(
        preorder1,
        inorder1,
        0,
        inorder1.length - 1,
        new int[]{0},
        map
);
BinaryTree bt=new BinaryTree();
bt.root=root;
bt.printTree();
   }
}