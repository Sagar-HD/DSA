

import java.util.*;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class BFS {
   
static void printBfs(Node node,Queue<Node> queue){
if(node==null){
    return;
}
    System.out.println(node.value);

    if(node.left!=null){
        queue.offer(node.left);
       
    }
    if(node.right!=null){
         queue.offer(node.right);
    }
    if(!queue.isEmpty()){
    Node next=queue.poll();
     printBfs(next, queue);
    }
  
   
}


static void printBfsIteration(Node root){
    if(root==null){
        return;
    }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curNode=queue.poll();
           System.out.println(curNode.value);
           if(curNode.left!=null){
            queue.offer(curNode.left);
           }
           if (curNode.right!=null) {
            queue.offer(curNode.right);
           }
            
        }
    
}

static List<List<Integer>> getBfs(Node root){
    List<List<Integer>> result=new ArrayList<>();
    if(root==null){
        return result;
    }
    Queue<Node> queue=new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
        int levelSize=queue.size();
        List<Integer> currentLevelList=new ArrayList<>();
        for(int i=0;i<levelSize;i++){
            Node curNode=queue.poll();
            currentLevelList.add(curNode.value);
            if(curNode.left!=null){
                queue.offer(curNode.left);
            }
               if(curNode.right!=null){
                queue.offer(curNode.right);
            }
        
        }
        result.add(currentLevelList);
    
    }
    return result;

}

public static void main(String[] args) {
   BinaryTree bt=new BinaryTree();
   int[] arr={1,2,41,3,4,2,68};
   bt.populateTree(arr);
   Queue<Node> queue=new LinkedList<>();
   printBfs(bt.root,queue);
   System.out.println("///////////////");
   printBfsIteration(bt.root);
System.out.println("///////////////");
   List<List<Integer>> ans=getBfs(bt.root);
   for(List<Integer> list:ans){
    System.out.println(list);
   }
}
    
}