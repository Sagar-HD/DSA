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
    class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode node,int index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        if(root==null){
            return 0;
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int levelSize=queue.size();
        
            int start=0;
            int end=0;
            int min=queue.peek().index;
            for(int i=0;i<levelSize;i++){
                Pair curPair=queue.poll();
                if(i==0){
                    start=curPair.index-min;
                }
                 if(i==levelSize-1){
                    end=curPair.index-min;
                }
                if(curPair.node.left!=null){
                    queue.offer(new Pair(curPair.node.left,(2*(curPair.index-min))));
                }
                  if(curPair.node.right!=null){
                    queue.offer(new Pair(curPair.node.right,(2*(curPair.index-min))+1));
                }
            }
            int levelWidth=end-start+1;
            maxWidth=Math.max(maxWidth,levelWidth);
        }
        return maxWidth;
        
    }
}