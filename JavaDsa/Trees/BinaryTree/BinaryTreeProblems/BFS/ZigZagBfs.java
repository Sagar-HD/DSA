package Trees.BinaryTree.BinaryTreeProblems;

import java.util.Deque;
import java.util.LinkedList;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class ZigZagBfs {
    /*
    For normal, remove from front and add to back. For reverse,
    remove from back and add to front. After the reverse level finishes,
    the deque is arranged such that the next level can be processed normally.
    
    */
    static void printZigZagBfs(Node root){
        if(root==null){
            return;
        }
        Deque<Node> deque=new LinkedList<>();
        deque.offerFirst(root);
        boolean revesre=false;
        while(!deque.isEmpty()){
             int levelSize=deque.size();
             
             //we can also write if else inside for loop and make it clean 

            if(!revesre){
               
             
                for(int i=0;i<levelSize;i++){
                       Node curNode=deque.pollFirst();
                    System.out.print(curNode.value);
                    if(curNode.left!=null){
                        deque.offerLast(curNode.left);
                    }
                      if(curNode.right!=null){
                        deque.offerLast(curNode.right);
                    }
                }
                System.out.println();
                revesre=!revesre;
            
            }
            else{
        //while reverse adding add right first then left to front so next level order gets maintained
                  for(int i=0;i<levelSize;i++){
                            Node curNode=deque.pollLast();
                    System.out.print(curNode.value);
                     if(curNode.right!=null){
                        deque.offerFirst(curNode.right);
                    }
                    if(curNode.left!=null){
                        deque.offerFirst(curNode.left);
                    }
                     
                }
                    System.out.println();
                revesre=!revesre;

            }
        }

    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6};
        bt.populateTree(arr);
        printZigZagBfs(bt.root);
    }
}