package Trees.BinaryTree.BinaryTreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class BFSfromBottom {
    static List<List<Integer>> getBfs(Node root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
return ans;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int curLevelSize=queue.size();
            ArrayList<Integer> curLevelList=new ArrayList<>();
            for(int i=0;i<curLevelSize;i++){
                Node curNode=queue.poll();
                curLevelList.add(curNode.value);
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                  if(curNode.right!=null){
                    queue.add(curNode.right);
                }
                
                
            }
            ans.add(0,curLevelList);
            
        }
        return ans;
        
        
    }
    public static void main(String[] args) {
           BinaryTree bt=new BinaryTree();
   int[] arr={1,2,41,3,4,2,68};
   bt.populateTree(arr);
          List<List<Integer>> ans=getBfs(bt.root);
   for(List<Integer> list:ans){
    System.out.println(list);
   }
    }
    
}
