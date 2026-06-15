package Trees.BinaryTree.BinaryTreeProblems.DFS.NodeReturningFromChildProblems;

import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;


public class LowestCommonAncestor {
    static class Result{
        int count;
        Node lca;
        Result(int count,Node lca){
            this.count=count;
            this.lca=lca;
        }
    }


    /*
    This the complicated soltuion
    if expects child to return how many noes it found and If it found  Lca already return it or keep it null
    my core idea is we are comming upward so we will find Lca at bottom only
    at each node while comming from bottom we take left Result and Right result
    if any lca is found in either left or right retuning that to parent
    else check if my contribution makes me lca 
    if yes return the current node as Lca
    if no Lca is found found from childrens or Myself cannot be Lca just progate the info i know to mt parent
    so this is the complex solution i came up with
    This is postOrder solution
    ////////////////////////
    but why to prefer standard approach means
    in a node if its either p or q we can no need to go depper bcs lca will be this or above node 
    so we check another side to the nodes 
    if we get nodes from both left and right we return parent as Lca
    if one node gives node other gives null then return the node which node as Lca bcs the other one might be below it deeper anywhere 
    if both gives null return null only 
    This is PreOrder Solution
    
    */
    public static Result getLca(Node node,Node p,Node q){
        if(node==null){
            return new Result(0, null);
        }
       Result leftResult= getLca(node.left,p,q);
        if(leftResult.lca!=null){
        return leftResult;
       }
       
       Result rightResult=getLca(node.right,p,q);
      
        if(rightResult.lca!=null){
        return rightResult;
       }
       
       int selfCount=node==p || node==q ? 1 : 0;
       int totalCount=leftResult.count+rightResult.count+selfCount;
       if(totalCount==2){
        return new Result(totalCount, node);
       }
       return new Result(totalCount, null);
    }
    /// second and standard approach so i can get Node only as result not an another class of state
    
    public static Node getLcaStandard(Node node,Node p,Node q){
        if(node==null){
        return null;
        }

          if(node==p||node==q){
            //if node is any one of p or q return this node
            // Found one of the targets.
            // Return it upward so ancestors can determine the LCA.
            //this is just found a target not an lca
            //parent decides the lca if this is only root then this is the lcs bcs of common sense if one of the elemnt is root only then it can only be lca
        
            return node;
        }

        Node left=getLcaStandard(node.left,p,q);
        Node right=getLcaStandard(node.right,p,q);
      
       
        if(left!=null&&right!=null){
             //this node is lca
            return node;
        }
        if(left==null&&right!=null){
            //both node in right side
          return right;
        }
     if(left!=null&&right==null){
            //both node in left side
          return left;
        }
        //if any condition doesnt match then both null neither in left nor right so return null
        return null;
    }

   




    public static void main(String[] args) {
     
        /*
                  3
                /   \
               5     1
              / \   / \
             6   2 0   8
                / \
               7   4
        */

        BinaryTree bt = new BinaryTree();

bt.root = new BinaryTree.Node(3);

bt.root.left = new BinaryTree.Node(5);
bt.root.right = new BinaryTree.Node(1);

bt.root.left.left = new BinaryTree.Node(6);
bt.root.left.right = new BinaryTree.Node(2);

bt.root.right.left = new BinaryTree.Node(0);
bt.root.right.right = new BinaryTree.Node(8);

bt.root.left.right.left = new BinaryTree.Node(7);
bt.root.left.right.right = new BinaryTree.Node(4);
Node root = bt.root;

Node five = bt.root.left;
Node one = bt.root.right;
Node six = bt.root.left.left;
Node two = bt.root.left.right;
Node seven = bt.root.left.right.left;
Node four = bt.root.left.right.right;
Node zero = bt.root.right.left;
Node eight = bt.root.right.right;



//test cases 

System.out.println("LCA(5,1) = " +
        getLca(bt.root, five, one).lca.value);     // 3

System.out.println("LCA(6,4) = " +
        getLca(bt.root, six, four).lca.value);     // 5

System.out.println("LCA(7,4) = " +
        getLca(bt.root, seven, four).lca.value);   // 2

System.out.println("LCA(6,2) = " +
        getLca(bt.root, six, two).lca.value);      // 5

System.out.println("LCA(0,8) = " +
        getLca(bt.root, zero, eight).lca.value);   // 1

System.out.println("LCA(6,8) = " +
        getLca(bt.root, six, eight).lca.value);    // 3

System.out.println("LCA(7,1) = " +
        getLca(bt.root, seven, one).lca.value);    // 3

System.out.println("LCA(2,4) = " +
        getLca(bt.root, two, four).lca.value);     // 2

System.out.println("LCA(5,4) = " +
        getLca(bt.root, five, four).lca.value);    // 5




        System.out.println(
    getLcaStandard(bt.root, six, four).value); // 5

System.out.println(
    getLcaStandard(bt.root, five, four).value); // 5

System.out.println(
    getLcaStandard(bt.root, six, eight).value); // 3

    }


    

    

    
}