package Trees.BinaryTree.BinaryTreeProblems.DFS.PrimitiveReturnFromChildProblems;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class MaxDepthOfBinaryTree {
    //silly problem asking height of tree but in differnt words
     public static int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        
        return Math.max(left,right)+1;

        
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6,7,8};
        bt.populateTree(arr);
        System.out.println(maxDepth(bt.root));
    }
    
}
