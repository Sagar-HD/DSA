package Trees.BinaryTree.BinaryTreeProblems.DFS.PathProblems_passing_info_downwards;

import java.util.ArrayList;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

//path sum from root to any leaf node == target is there or not 
public class PathSum {
    static boolean isPathPresent(Node node, int target) {
        if (node == null) {
            return false;
        }
    
        if (node.left == null && node.right == null) {
                //this condition means we are standing at a leaf node
                //only at leaf node we check is path sum=taget, not in null node or root node 
                if(node.value==target){
                    return true;
                }
        }
        //the below is for non-leaf nodes
        return isPathPresent(node.left, target-node.value)||isPathPresent(node.right, target-node.value);
    }



     static ArrayList<ArrayList<Integer>> allPaths(Node node, int target,ArrayList<Integer> pathInThisBranch) {
         ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
        if (node == null) {
              ArrayList<ArrayList<Integer>> path=new ArrayList<>();
            return path;
        }
    
        if (node.left == null && node.right == null) {
                //this condition means we are standing at a leaf node
                //only at leaf node we check is path sum=taget, not in null node or root node 
                if(node.value==target){
                    pathInThisBranch.add(node.value);
                  
                    paths.add(new ArrayList<>(pathInThisBranch));
                     pathInThisBranch.remove(pathInThisBranch.size()-1);
                   
                }
                 return paths;
        }
        //the below is for non-leaf nodes
       pathInThisBranch.add(node.value);
       paths.addAll(allPaths(node.left, target-node.value,pathInThisBranch));
       paths.addAll(allPaths(node.right, target-node.value, pathInThisBranch));
        pathInThisBranch.remove(pathInThisBranch.size()-1);
        return paths;
    }
    

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int arr[] = { 1, 2, 3, 9, 5, 6, 7,2,1,3 };
        bt.populateTree(arr);
        bt.printTree();
        System.out.println(isPathPresent(bt.root, 7));
        System.out.println(isPathPresent(bt.root, 8));
        System.out.println(isPathPresent(bt.root, 9));
        System.out.println(isPathPresent(null, 0));
        ArrayList<ArrayList<Integer>> ans=allPaths(bt.root, 11, new ArrayList<>());
        for(ArrayList<Integer> path:ans){
            System.out.println(path);
        }



    }

}
