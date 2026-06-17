package Trees.BinaryTree.BinaryTreeProblems.DFS.PrimitiveReturnFromChildProblems;

import java.util.HashSet;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class TwoSum {
      public static boolean helper(Node root, int k,HashSet<Integer> set){
        if(root==null){
            return false;
        }
        if(set.contains(root.value)){
            return true;
        }
        else{
            set.add(k-root.value);
            return helper(root.left,k,set)||helper(root.right,k,set);
        }

    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,4,2,5,9,3};
        bt.populateTree(arr);
        System.out.println(helper(bt.root, 14, new HashSet<>()));
    }

    
}