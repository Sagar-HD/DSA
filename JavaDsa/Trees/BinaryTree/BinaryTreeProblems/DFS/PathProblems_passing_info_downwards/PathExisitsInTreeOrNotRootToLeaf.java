package Trees.BinaryTree.BinaryTreeProblems.DFS.PathProblems_passing_info_downwards;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class PathExisitsInTreeOrNotRootToLeaf {
    public static boolean isPathExists(Node root,int[] arr){
        if(root==null){
            //if root is only null
            //return true when array is empty else return false

            return arr.length==0;
        }
        return helper(root,arr,0);
        
    }
    static boolean helper(Node node,int[] arr,int index){
        if(node==null){
            return false;
        }
        if(index>=arr.length || node.value!=arr[index]){
            return false;
        }
        if(node.left==null && node.right==null && index==arr.length-1){
            return true;
        }
        return helper(node.left, arr, index+1)||helper(node.right, arr, index+1);
    }


    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6};
        bt.populateTree(arr);
        bt.printTree();
        int[] path={1,3,6};
        int[] path2={1,3,5};
        System.out.println(isPathExists(bt.root, path));
        System.out.println(isPathExists(bt.root, path2));


    }

}