


 
class Solution {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    public int getHeight(TreeNode node){
        if(node==null){
            return -1;
        }
        return 1+ Math.max(getHeight(node.left), getHeight(node.right));
        
    
    }
   
    
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(getHeight(root.left)- getHeight (root.right))<=1){
            if(!isBalanced(root.left)){
                return false;
            }
            if(!isBalanced(root.right)){
                return false;
            }
        }
        else{
            return false;
        }
        return true ;
    }
}