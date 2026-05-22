package RecursionCombiningAnsFromBelow;

import Trees.BinarySearchTree.BinarySearchTree;
import Trees.BinarySearchTree.BinarySearchTree.Node;
public class TreeHeight {
    static int findHeightByRecursion(Node node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(findHeightByRecursion(node.left),findHeightByRecursion(node.right));
   
    }
public static void main(String[] args) {
    BinarySearchTree bst=new BinarySearchTree();
    int[] arr={1,4,6,7,8,9,20};
    bst.populateTree(arr);
    bst.display();
    System.out.println("height :");
    System.out.println(findHeightByRecursion(bst.root));
    
}
    
}