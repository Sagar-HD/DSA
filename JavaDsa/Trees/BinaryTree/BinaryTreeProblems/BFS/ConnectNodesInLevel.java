package Trees.BinaryTree.BinaryTreeProblems;


import java.util.LinkedList;

import java.util.Objects;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;
//tree must be perfect binaty tree for this problem
public class ConnectNodesInLevel {
    static void connectNodes(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
           
            for(int i=0;i<levelSize;i++){
             Node curNode=queue.poll();
           //doing this bcs always last node of level is null
             if(i==levelSize-1){
                curNode.next=null;
             }
             else{
                curNode.next=queue.peek();
             }

             if(Objects.nonNull(curNode.left)){
                queue.add(curNode.left);
             }
              if(Objects.nonNull(curNode.right)){
                queue.add(curNode.right);
             }

            }
         

        }
        
    }
     static void connectNodesWithoutQueue(Node node){
        //return in leaf node and null node
       if(node == null || node.left == null){
                    return;
            }
        node.left.next=node.right;
        connectNodesWithoutQueue(node.left);
       if(node.next!=null){
        node.right.next=node.next.left;
       }
       else{
        node.right.next=node.next;
        //or marking it as null
       }
        connectNodesWithoutQueue(node.right);


     }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        //tree must be perfect binaty tree for this problem
       int[] arr = {1,2,3,4,5,6,7};
        bt.populateTree(arr);
        connectNodes(bt.root);
        
    }
    
}
