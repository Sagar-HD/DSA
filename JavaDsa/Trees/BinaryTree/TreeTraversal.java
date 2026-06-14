package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

import Trees.BinaryTree.BinaryTree.Node;

public class TreeTraversal {

    public static void preOrder(BinaryTree tree) {
        if (tree != null) {
            helperPreOrder(tree.root);
        }

    }

    public static void helperPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        helperPreOrder(node.left);
        helperPreOrder(node.right);
    }

    public static void inOrder(BinaryTree tree) {
        if (tree != null) {
            helperInOrder(tree.root);
        }

    }

    public static void helperInOrder(Node node) {
        if (node == null) {
            return;
        }

        helperInOrder(node.left);
        System.out.print(node.value);
        helperInOrder(node.right);
    }

    public static void postOrder(BinaryTree tree) {
        if (tree != null) {
            helperPostOrder(tree.root);
        }
    }

    public static void helperPostOrder(Node node) {
        if (node == null) {
            return;
        }

        helperPostOrder(node.left);

        helperPostOrder(node.right);
        System.out.print(node.value);
    }

    public static ArrayList<Integer> inorderMorrisTraversal(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        if (root == null) {
            return inOrder;
        }
        Node cur = root;
        while (cur != null) {
            // if left doesnt exists just add node value and go move towards right
            // if left it null it just move to right if right is null it move to null and
            // when its null it exit the loop
            // loop exit when there no left and right
            // it doesnt means it exits in every leaf node
            // if we have next right node to traverse then we will be adding thread to that
            // node so in that it doesnt exit

            if (cur.left == null) {
                inOrder.add(cur.value);
                cur = cur.right;
            } else {

                Node predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                // predecessor is the rightmost node in cur's left subtree
                // inorder predecessor of cur
                // here this loop can end in another condition where we came to current node
                // after processing complete left tree
                // we must handle both
                if (predecessor.right == null) {
                    // before going to left we are connecting the rightmost of it to currents node
                    // beacuse after going there we must come back to current node
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    // we finished processing left sub tree and moving to back to cur node then
                    // right
                    predecessor.right = null;
                    inOrder.add(cur.value);
                    cur = cur.right;
                }
            }

        }
        return inOrder;

    }

    // in pre order instead of adding node value while going to right after
    // finishing left
    // instead of doing above thing we add node valye before going to left node only
    // in case of left null its same as before just add node value and go to right
    public static ArrayList<Integer> preorderMorrisTraversal(Node root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Node cur = root;
        while (cur != null) {
            // if left doesnt exists just add node value and go move towards right
            // if left it null it just move to right if right is null it move to null and
            // when its null it exit the loop
            // loop exit when there no left and right
            // it doesnt means it exits in every leaf node
            // if we have next right node to traverse then we will be adding thread to that
            // node so in that it doesnt exit

            if (cur.left == null) {
                preOrder.add(cur.value);
                cur = cur.right;
            } else {

                Node predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur) {
                    predecessor = predecessor.right;
                }
                // predecessor is the rightmost node in cur's left subtree
                // inorder predecessor of cur
                // here this loop can end in another condition where we came to current node
                // after processing complete left tree
                // we must handle both
                if (predecessor.right == null) {
                    // before going to left we are connecting the rightmost of it to currents node
                    // beacuse after going there we must come back to current node
                    predecessor.right = cur;
                    preOrder.add(cur.value);
                    cur = cur.left;
                } else {
                    // we finished processing left sub tree and moving to back to cur node then
                    // right
                    predecessor.right = null;

                    cur = cur.right;
                }
            }

        }
        return preOrder;

    }
//bfs traversal using queue no need of explainantion i think
//just maintain the order od elements to be processed in queue and keep on processing from left to right
//at each level queue size is level size , just process or remove all elements of level using level size 
// while processing this level add in order to queue of next level to be processed 
   public static void breadthFirstSearchIteration(Node root){
    if(root==null){
        return;
    }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                Node curNode=queue.poll();
                System.out.print(curNode.value);
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                 if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
            }
            System.out.println();
            //processing of a level finsihed noe going to next level

        }
        //after completing all level queue will be empty we will return

   }
   //i expect root to be added in queue not its not null // if dont like this we can have helper function
   public static void breadthFirstSearchRecursion(Queue<Node> queue){
    if(queue.isEmpty()){
        return;
    }
    
    Node cur=queue.poll();
    System.out.print(cur.value);
    if(cur.left!=null){
        queue.offer(cur.left);
        
    }
     if(cur.right!=null){
        queue.offer(cur.right);
    }
     breadthFirstSearchRecursion(queue);
   }
//for dfs using iteration ill show preOrder
public static void preOrderDfsIterative(Stack<Node> stack){
   while(!stack.isEmpty()){
    Node cur=stack.pop();
    System.out.print(cur.value);
    //for pre order pushing left last bcs in stack last in is first out
    if(cur.right!=null){
        stack.push(cur.right);
    }
     if(cur.left!=null){
        stack.push(cur.left);
    }
   }

}

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        binaryTree.populateTree(arr);
        System.out.println("pre order traversal");
        TreeTraversal.preOrder(binaryTree);
        System.out.println();
        System.out.println("in order traversal");
        TreeTraversal.inOrder(binaryTree);
        System.out.println();
        System.out.println("post order traversal");
        TreeTraversal.postOrder(binaryTree);
        System.out.println();
        System.out.println("Morris Inorder Traversal");
        ArrayList<Integer> inOrderMosris = inorderMorrisTraversal(binaryTree.root);
        System.out.println(inOrderMosris);
        System.out.println("Morris preOrder Traversal");
        ArrayList<Integer> preOrderMosris = preorderMorrisTraversal(binaryTree.root);
        System.out.println(preOrderMosris);
          System.out.println("Breadth First Search Iteration");
          breadthFirstSearchIteration(binaryTree.root);
            System.out.println("Breadth First Search Recursion");
            Queue<Node> queue=new LinkedList<>();
            if(binaryTree.root!=null){
                queue.offer(binaryTree.root);
          breadthFirstSearchRecursion(queue);
            }
            System.out.println();
          //iterative preorder dfs 
          System.out.println("pre order iterative");
          if(binaryTree.root!=null){
          Stack<Node> stack=new Stack<>();
          stack.push(binaryTree.root);
          preOrderDfsIterative(stack);

          }
    }

}
