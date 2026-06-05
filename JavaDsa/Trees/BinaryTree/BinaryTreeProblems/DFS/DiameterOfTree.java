package Trees.BinaryTree.BinaryTreeProblems.DFS;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class DiameterOfTree {
    private static Integer diameter=0;
    static int diameter(Node root){
        if(root==null){
            return 0;
        }
        height(root);
        return DiameterOfTree.diameter-1;
    }
    static int height(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        int dia=leftHeight+rightHeight+1;
        DiameterOfTree.diameter=Math.max(dia,DiameterOfTree.diameter);
        return 1+Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
          // Tree 1
        BinaryTree bt1 = new BinaryTree();

        bt1.root = new Node(1);
        bt1.root.left = new Node(2);
        bt1.root.right = new Node(3);

        bt1.root.left.left = new Node(4);
        bt1.root.left.right = new Node(5);

        System.out.println(diameter(bt1.root));


        // Tree 2 (skewed)
        BinaryTree bt2 = new BinaryTree();

        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.left.left = new Node(3);
        bt2.root.left.left.left = new Node(4);
        bt2.root.left.left.left.left = new Node(5);

        System.out.println(diameter(bt2.root));


        // Tree 3
        BinaryTree bt3 = new BinaryTree();

        bt3.root = new Node(1);
        bt3.root.left = new Node(2);
        bt3.root.right = new Node(3);

        bt3.root.left.left = new Node(4);
        bt3.root.left.left.left = new Node(5);

        bt3.root.right.right = new Node(6);
        bt3.root.right.right.right = new Node(7);

        System.out.println(diameter(bt3.root));


        // Single node
        BinaryTree bt4 = new BinaryTree();

        bt4.root = new Node(1);

        System.out.println(diameter(bt4.root));


        // Empty tree
        BinaryTree bt5 = new BinaryTree();

        bt5.root = null;

        System.out.println(diameter(bt5.root));
        
    }

}