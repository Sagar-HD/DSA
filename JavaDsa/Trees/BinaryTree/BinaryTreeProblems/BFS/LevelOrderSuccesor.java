package Trees.BinaryTree.BinaryTreeProblems;

import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class LevelOrderSuccesor {

    static Node getSuccesor(Node root,int value){
           if(root==null){
            return null;
           }
           Queue<Node> queue=new LinkedList<>();
           queue.offer(root);
           while(!queue.isEmpty()){
            Node curNode=queue.poll();
            if(curNode.left!=null){
                queue.offer(curNode.left);
            }
             if(curNode.right!=null){
                queue.offer(curNode.right);
            }
            if(curNode.value==value){
            return queue.poll();
            }
           

           }
           return null;

    }


    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5};
        bt.populateTree(arr);
        Node sucessor=getSuccesor(bt.root, 3);
        if(sucessor==null){
            System.out.println("not found");
        }
        else{
            System.out.println("ans :"+sucessor.value);
        }
    }
    
}
