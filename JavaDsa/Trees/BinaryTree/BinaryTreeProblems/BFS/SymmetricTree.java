package Trees.BinaryTree.BinaryTreeProblems.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class SymmetricTree {
    //dont use this method just undersatnd wt all problem it created how i solved 
    //why going to another approach is better bcs it naturally stores pairs understading this is important
    //key learning is we need to store the only information that is needed to solve problem for example
    //for bfs next node which has to be explored or processed
    //for cousin problem level of 2 nodes and their parent
    //now in this symmetry the pairs , keeping the pairs which needs to checked together
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


    public static void main(String[] args) {

        
     

    }

}
