package Trees.BinaryTree.BinaryTreeProblems.BFS;

import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree.Node;


public class MaximumWidthOfBinaryTree {

   class Pair{
        Node node;
        int index;
        public Pair(Node node,int index){
            this.node=node;
            this.index=index;
        }
    }

    public int widthOfBinaryTree(Node root) {
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
public static void main(String[] args) {
    //Be smart use chat gpt to add TestCases 😎

    MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();

    // Test Case 1
    //       1
    //      / \
    //     2   3
    // Width = 2
    Node root1 = new Node(1);
    root1.left = new Node(2);
    root1.right = new Node(3);

    System.out.println("Test Case 1 Width: " +
            obj.widthOfBinaryTree(root1)); // Expected: 2


    // Test Case 2
    //         1
    //       /   \
    //      3     2
    //     / \     \
    //    5   3     9
    // Width = 4
    Node root2 = new Node(1);
    root2.left = new Node(3);
    root2.right = new Node(2);
    root2.left.left = new Node(5);
    root2.left.right = new Node(3);
    root2.right.right = new Node(9);

    System.out.println("Test Case 2 Width: " +
            obj.widthOfBinaryTree(root2)); // Expected: 4


    // Test Case 3
    //           1
    //         /   \
    //        3     2
    //       /
    //      5
    // Width = 2
    Node root3 = new Node(1);
    root3.left = new Node(3);
    root3.right = new Node(2);
    root3.left.left = new Node(5);

    System.out.println("Test Case 3 Width: " +
            obj.widthOfBinaryTree(root3)); // Expected: 2


    // Test Case 4
    //           1
    //         /   \
    //        3     2
    //       /       \
    //      5         9
    //     /           \
    //    6             7
    // Width = 8
    Node root4 = new Node(1);
    root4.left = new Node(3);
    root4.right = new Node(2);
    root4.left.left = new Node(5);
    root4.right.right = new Node(9);
    root4.left.left.left = new Node(6);
    root4.right.right.right = new Node(7);

    System.out.println("Test Case 4 Width: " +
            obj.widthOfBinaryTree(root4)); // Expected: 8


    // Test Case 5 - Single Node
    Node root5 = new Node(10);

    System.out.println("Test Case 5 Width: " +
            obj.widthOfBinaryTree(root5)); // Expected: 1


    // Test Case 6 - Empty Tree
    System.out.println("Test Case 6 Width: " +
            obj.widthOfBinaryTree(null)); // Expected: 0
}
    
}


