package Trees.BinaryTree.BinaryTreeProblems.BFS;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;


public class VerticalOrderTraversal {
      public static class State{
        Node node;
        int index;
        public State(Node node,int index){
            this.node=node;
            this.index=index;
        }

      }

    public static void verticalOrder(Node node){
        if(node==null){
            return;
        }
        HashMap<Integer,LinkedList<Integer>> map=new HashMap<>();
        Queue<State> q=new LinkedList<>();
        q.offer(new State(node, 0));
        int min=0;
        int max=0;
        while(!q.isEmpty()){
            //no need to maintain level size
            State cur=q.poll();
            min=Math.min(min, cur.index);
            max=Math.max(max,cur.index);
            LinkedList<Integer> list=map.getOrDefault(cur.index,new LinkedList<>());
             list.add(cur.node.value);

            map.put(cur.index,list);
            
            if(cur.node.left!=null){
                q.offer(new State(cur.node.left, cur.index-1));
            }
             if(cur.node.right!=null){
                q.offer(new State(cur.node.right, cur.index+1));
            }
            
        }
        for(int i=min;i<=max;i++){
            System.out.println(map.get(i)+" index"+i);
        }

    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,5,2,8,9};
        bt.populateTree(arr);
        bt.printTree();
        verticalOrder(bt.root);
    }
    
}
