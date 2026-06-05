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
    public List<Double> averageOfLevels(TreeNode root) {
         List<Double> ans=new ArrayList<>();
         if(root==null){
            return ans;
         }
         Queue<TreeNode> queue=new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
         int levelSize=queue.size();
         double sum=0;
         for(int i=0;i<levelSize;i++){
            TreeNode curNode=queue.poll();
            sum+=curNode.val;
            if(curNode.left!=null){
                queue.offer(curNode.left);
            }
            if(curNode.right!=null){
                queue.offer(curNode.right);
            }
         }
         double average=sum/levelSize;
         ans.add(average);
         }
        return ans;
    }
}