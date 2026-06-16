package Trees.BinaryTree;
// parent node for all Node of diffrent tree
//made this parent interface just bcs i can use a generic parent ref in all problems
public interface TreeNode {
    TreeNode getLeft();
    TreeNode getRight();
    int getValue();


    
}
