

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

//this problem can be solved using dfs like traversing right node first then left
//we pass on depth also in state , we make sure that the first node we encounter at each level is added 
//by seeing if depth==ans.size() we add , by this even if right is null it goes left then sees if depth ==ans.size() and adds its
//when we already added rightmost node comming back after reaching deepest node ,now depth will not be equal to ans.size() bcs for this level we already added when we first visited this level
 static ArrayList<Integer> getRightSideViewDfs(Node root,int depth,ArrayList<Integer> ans){
    if(root==null){
        return ans;
    }
    if(depth==ans.size()){
        ans.add(root.value);
    }
    //visitr right first so it gets added in its level and left gets ignored
    getRightSideViewDfs(root.right, depth+1, ans);
    getRightSideViewDfs(root.left, depth+1, ans);
    //we can return ans also for keep it void also bcs it globally updating
    //if we return it will be returning in each node which is of no use but at top it return ans
   return ans;
 }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5};
        bt.populateTree(arr);
        ArrayList<Integer> ans=getRightSideView(bt.root);
        System.out.println(ans);
        ArrayList<Integer> ans2=getRightSideViewDfs(bt.root,0,new ArrayList<>());
        System.out.println(ans2);
        
    }
    
}
