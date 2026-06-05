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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
            if(root==null){
                return ans;
            }
            Queue<TreeNode> queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int curLevel=queue.size();
                List<Integer> curLevelList=new ArrayList<>();
                for(int i=0;i<curLevel;i++){
                TreeNode curNode=queue.poll();
                  curLevelList.add(curNode.val);
                  if(curNode.left!=null){
                    queue.offer(curNode.left);
                  }
                   if(curNode.right!=null){
                    queue.offer(curNode.right);
                  }
                
                }
                ans.add(curLevelList);


            }
      return ans;

            }
}