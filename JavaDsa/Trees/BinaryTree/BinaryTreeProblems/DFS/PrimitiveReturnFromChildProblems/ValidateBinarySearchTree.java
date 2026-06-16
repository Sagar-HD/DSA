package Trees.BinaryTree.BinaryTreeProblems.DFS.PrimitiveReturnFromChildProblems;

import Trees.BinarySearchTree.BinarySearchTree;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBst(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        // if min is not null and value of current node is in range means >low
        // if max is not null and value of current node is in range means <high
        // then only we check its children else return false here only
        if ((max != null && node.getValue() >= max) || (min != null && node.getValue() <= min)) {
            return false;
        }
        // while going left upper limit to be set as node value bcs we can have only
        // value lesser than it in left side
        // while going right lower limit to be set as node value bcs we can have only
        // value gretaer than it in right side
        return isValidBst(node.getLeft(), min, node.getValue()) && isValidBst(node.getRight(), node.getValue(), max);

    }

    // this is my method from leetcode same approach

    // public boolean helper(TreeNode root,long low,long high){
    // if(root==null){
    // return true;
    // }
    // boolean isLeftValid=true;
    // boolean isRightValid=true;

    // if (root.val <= low || root.val >= high) {
    // return false;
    // }

    // if(root.left!=null){

    // isLeftValid=root.left.val<root.val && helper(root.left,low,root.val);

    // }
    // if(root.right!=null){

    // isRightValid=root.right.val>root.val && helper(root.right,root.val,high);

    // }
    // return isLeftValid&&isRightValid;

    // }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = { 1, 2, 9, 4, 7, 3, 6 };
        bst.populateTree(arr);
        BinaryTree bt = new BinaryTree();
        bt.populateTree(arr);
        System.out.println(isValidBst(bst.root, null, null));
        System.out.println(isValidBst(bt.root, null, null));

    }

}