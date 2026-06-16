package Trees.BinaryTree.BinaryTreeProblems.DFS.PathProblems_passing_info_downwards;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class SumOfNumbersFormedAtAllLeafNodes {

    //simple only at leaf node returning answer adding left and right answer and propogating to parent

      public static int find(Node root,int num){
        if(root==null){
           return 0;
        }
        if(root.left==null && root.right==null){
            num=(num*10)+root.value;
            return num;
        }
        num=(num*10)+root.value;
        int leftNum=find(root.left,num);
        int rightNum=find(root.right,num);
        return leftNum+rightNum;
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6,2,8};
        bt.populateTree(arr);
        System.out.println(find(bt.root,0));
        
    }
    
}
