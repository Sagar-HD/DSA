package Trees.BinaryTree.BinaryTreeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class RightSideViewOfATree {
    static ArrayList<Integer> getRightSideView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                Node curNode=queue.poll();
                if(i==levelSize-1){
                    ans.add(curNode.value);
                }
                if(Objects.nonNull(curNode.left)){
                    queue.offer(curNode.left);
                }
                  if(Objects.nonNull(curNode.right)){
                    queue.offer(curNode.right);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5};
        bt.populateTree(arr);
        ArrayList<Integer> ans=getRightSideView(bt.root);
        System.out.println(ans);
    }
    
}
