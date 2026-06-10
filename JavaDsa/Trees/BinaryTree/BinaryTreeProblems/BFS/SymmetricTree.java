package Trees.BinaryTree.BinaryTreeProblems.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class SymmetricTree {
    // dont use this method just undersatnd wt all problem it created how i solved
    // why going to another approach is better bcs it naturally stores pairs
    // understading this is important
    // key learning is we need to store the only information that is needed to solve
    // problem for example
    // for bfs next node which has to be explored or processed
    // for cousin problem level of 2 nodes and their parent
    // now in this symmetry the pairs , keeping the pairs which needs to checked
    // together
    static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            // same like palindrome instead of start end iam using levelSize to check and
            // pollFirst and pollLast
            // iam having nextlevel as seperate deque bcs by just level size iam not able
            // make sure iam only poping this level elemrnt
            // while poping from front and back i make take out next levels node if i add to
            // same queue
            // so iam having this new queue
            Deque<Node> nextLevel = new LinkedList<>();
            while (levelSize > 1) {
                Node firstNode = deque.pollFirst();
                Node lastNode = deque.pollLast();
                if (checkNodeSymetry(firstNode, lastNode)) {
                    if (firstNode != null) {
                        nextLevel.add(firstNode.left);
                        nextLevel.add(firstNode.right);
                    }
                    if (lastNode != null) {
                        nextLevel.add(lastNode.left);
                        nextLevel.add(lastNode.right);
                    }

                } else {
                    return false;
                }
                levelSize = levelSize - 2;

            }
            // in our approach we may have one left out node in case of odd number of nodes
            // in tree
            // i need to procees this level completely before going to next level
            // wait but iam adding nulls also so level will always be even only like 2 4 6 8
            // so this condition is necessary for root node only which has only 1 node
            // adding remaining node child to nextlevel deqeue
            if (levelSize == 1) {
                Node remainingNode = deque.poll();
                if (remainingNode != null) {
                    nextLevel.add(remainingNode.left);
                    nextLevel.add(remainingNode.right);
                }
            }
            // updating queue with next level
            deque = nextLevel;

        }

        return true;

    }

    static boolean checkNodeSymetry(Node firstNode, Node lastNode) {

        if (firstNode == null && lastNode == null) {
            return true;
        }
        if (firstNode == null || lastNode == null) {
            return false;
        }
        return firstNode.value == lastNode.value;

    }

    /// uffff i need to take care of many things if i go interms of palindrom
    /// soo i decided to add the childrens in form of pairs so it becomes natural to
    /// check and avoids next level boundaris mixing
    /*
     * Before: Had to convert symmetry into a level-palindrome problem.
     * Now: Directly checks mirror pairs, which matches the actual definition of
     * symmetry.
     * Before: Had to manage levels, track level size, and ensure current and next
     * levels didn't mix.
     * Now: No level bookkeeping; each queue entry is simply a mirror pair to check.
     * Before: Had to worry whether children were being added in the correct order
     * for future palindrome checks.
     * Now: Mirror relationships are stored explicitly, so ordering concerns
     * disappear.
     * Before: Had to carefully preserve nulls and tree structure through levels.
     * Now: Null and structure mismatches are detected naturally when comparing
     * pairs.
     * Before: Correctness depended on several moving parts working together
     * (levels, ordering, nulls, palindrome checks).
     * Now: Correctness depends on one simple invariant: every queued pair must be
     * mirror images.
     * 
     */
    // by considering all above points ill use the below another methods
    // if had chose this method earlier life would be easy
    // but i dont want my life to be easy thats the problem 😂

    static boolean easyCheck(Node root) {
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        // just not adding first root node start from their children to make lyf bit
        // easy now
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            // in this approach no need to maintain level size as we keep on adding pairs in
            // queue we will check complete queue withou worrying about level
            Node pair1 = queue.poll();
            Node pair2 = queue.poll();
            if (checkNodeSymetry(pair1, pair2)) {
                if (pair1 != null) {
                    queue.add(pair1.left);
                }
                if (pair2 != null) {
                    queue.add(pair2.right);

                }
                if (pair1 != null) {
                    queue.add(pair1.right);
                }
                if (pair2 != null) {
                    queue.add(pair2.left);

                }

            } else {
                return false;
            }

        }
        return true;

    }

    // i found another techinque actaully this was the first intution that came to m
    // when i first saw the problem
    // but then i thought its wrong and moved for dfs
    // symetric check by dfs
    static boolean isSymmetricDfs(Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetricDfsHelper(root.left, root.right);
    }

    static boolean isSymmetricDfsHelper(Node left, Node right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        return left.value == right.value
                && isSymmetricDfsHelper(left.left, right.right)
                && isSymmetricDfsHelper(left.right, right.left);

    }

    public static void main(String[] args) {

        // Symmetric
        BinaryTree bt1 = new BinaryTree();

        bt1.root = new Node(1);
        bt1.root.left = new Node(2);
        bt1.root.right = new Node(2);

        bt1.root.left.left = new Node(3);
        bt1.root.left.right = new Node(4);

        bt1.root.right.left = new Node(4);
        bt1.root.right.right = new Node(3);

        System.out.println(isSymmetric(bt1.root));

        // Not Symmetric (structure)
        BinaryTree bt2 = new BinaryTree();

        bt2.root = new Node(1);
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(2);

        bt2.root.left.right = new Node(3);
        bt2.root.right.right = new Node(3);

        System.out.println(isSymmetric(bt2.root));

        // Symmetric with missing children
        BinaryTree bt3 = new BinaryTree();

        bt3.root = new Node(1);
        bt3.root.left = new Node(2);
        bt3.root.right = new Node(2);

        bt3.root.left.left = new Node(3);
        bt3.root.right.right = new Node(3);

        System.out.println(isSymmetric(bt3.root));

        // Not Symmetric (values)
        BinaryTree bt4 = new BinaryTree();

        bt4.root = new Node(1);
        bt4.root.left = new Node(2);
        bt4.root.right = new Node(2);

        bt4.root.left.left = new Node(3);
        bt4.root.left.right = new Node(5);

        bt4.root.right.left = new Node(4);
        bt4.root.right.right = new Node(3);

        System.out.println(isSymmetric(bt4.root));

        // Single node
        BinaryTree bt5 = new BinaryTree();

        bt5.root = new Node(1);

        System.out.println(isSymmetric(bt5.root));

        // Empty tree
        BinaryTree bt6 = new BinaryTree();

        bt6.root = null;

        System.out.println(isSymmetric(bt6.root));
        //
        System.out.println("easy check method");
        System.out.println(easyCheck(bt1.root));
        System.out.println(easyCheck(bt2.root));
        System.out.println(easyCheck(bt3.root));
        System.out.println(easyCheck(bt4.root));
        System.out.println(easyCheck(bt5.root));
        System.out.println(easyCheck(bt6.root));

        System.out.println("symmetric check by dfs");
        // checking symmetry by dfs
        System.out.println(isSymmetricDfs(bt1.root));
        System.out.println(isSymmetricDfs(bt2.root));
        System.out.println(isSymmetricDfs(bt3.root));
        System.out.println(isSymmetricDfs(bt4.root));
        System.out.println(isSymmetricDfs(bt5.root));
        System.out.println(isSymmetricDfs(bt6.root));

    }

}
