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
    
    public boolean check(TreeNode pair1, TreeNode pair2){
        if(pair1==null && pair2 ==null){
            return true;
        }
        if(pair1==null || pair2==null){
            return false;
        }
        return (pair1.val==pair2.val);
        
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode pair1=queue.poll();
             TreeNode pair2=queue.poll();
             if(check(pair1,pair2)){
                 if(pair1!=null){
                     
                     queue.offer(pair1.left);
                     queue.offer(pair2.right);
                     queue.offer(pair1.right);
                     queue.offer(pair2.left);
                 }
                 
             }
             else{
                 return false;
             }
            
        }
        return true;
        
    }
}