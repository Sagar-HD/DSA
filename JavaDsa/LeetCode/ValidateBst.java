/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean helper(TreeNode root,long low,long high){
         if(root==null){
            return true;
        }
        boolean isLeftValid=true;
        boolean isRightValid=true;
        
          if (root.val <= low || root.val >= high) {
            return false;
        }

       if(root.left!=null){
      
         isLeftValid=root.left.val<root.val && helper(root.left,low,root.val);
        
       }
      if(root.right!=null){
      
         isRightValid=root.right.val>root.val && helper(root.right,root.val,high);
        
       }
return isLeftValid&&isRightValid;

    }



    public boolean isValidBST(TreeNode root) {
       return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
}