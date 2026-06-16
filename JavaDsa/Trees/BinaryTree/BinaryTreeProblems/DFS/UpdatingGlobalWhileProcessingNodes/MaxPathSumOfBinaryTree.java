package Trees.BinaryTree.BinaryTreeProblems.DFS.UpdatingGlobalWhileProcessingNodes;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

//similar to Diamter and Path sum by combining both problem we get this
//update max sum globally , in diameter we used to find height but here we use MaxSum
public class MaxPathSumOfBinaryTree {
    static int maxSum=Integer.MIN_VALUE;

    static int maxSum(Node node){

        if(node==null){
            return 0;
        }
       
        int leftMax=maxSum(node.left);
        int rightMax=maxSum(node.right);
        


//if left or right sum is negative just ignore it dont add to maxsumATnode
         leftMax=Math.max(0,leftMax);
          rightMax=Math.max(0,rightMax);

         //calculation max sum at node
         int maxSumAtNode=leftMax+rightMax+node.value;
         //updating globally for all nodes
         MaxPathSumOfBinaryTree.maxSum=Math.max(MaxPathSumOfBinaryTree.maxSum,maxSumAtNode );
         //return max sum from left and right to parent
         return Math.max(leftMax, rightMax)+node.value;


    }
public static void main(String[] args) {
    BinaryTree bt=new BinaryTree();
    int[] arr={1,2,3,4,5,9,5};
    bt.populateTree(arr);
    bt.printTree();
    maxSum(bt.root);
    System.out.println("max sum is :"+MaxPathSumOfBinaryTree.maxSum);
    
}
    
}
