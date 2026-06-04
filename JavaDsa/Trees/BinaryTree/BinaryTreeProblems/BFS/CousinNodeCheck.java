package Trees.BinaryTree.BinaryTreeProblems.BFS;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class CousinNodeCheck {
    static boolean isCousin(Node root, int x, int y) {
        Node xNode = findNode(root, x);
        Node yNode = findNode(root, y);
        return (level(root, x, 0) == level(root, y, 0)) && (!isSiblings(root, xNode, yNode));

    }

    static int level(Node node, int target, int level) {
        if (node == null) {
            return -1;
        }
        if (node.value == target) {
            return level;
        }
        int leftAns = level(node.left, target, level + 1);
        if (leftAns != -1) {
            return leftAns;
        }
        int rightAns = level(node.right, target, level + 1);
        if (rightAns != -1) {
            return rightAns;
        }

        return -1;
    }

    static boolean isSiblings(Node node, Node x, Node y) {
        if (node == null) {
            return false;
        }
        if (x == null || y == null) {
            return false;
        }
        return (node.left == x && node.right == y) || (node.left == y && node.right == x) || isSiblings(node.left, x, y)
                || isSiblings(node.right, x, y);

    }

    static Node findNode(Node node, int target) {
        if (node == null) {
            return null;
        }
        if (node.value == target) {
            return node;
        }
        Node leftAns = findNode(node.left, target);
        if (leftAns != null) {
            return leftAns;
        }
        Node rightAns = findNode(node.right, target);
        if (rightAns != null) {
            return rightAns;
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        bt.populateTree(arr);
        System.out.println(isCousin(bt.root, 2, 3));
        System.out.println(isCousin(bt.root, 4, 6));
    }

}
