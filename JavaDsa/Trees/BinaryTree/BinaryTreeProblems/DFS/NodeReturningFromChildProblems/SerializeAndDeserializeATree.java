package Trees.BinaryTree.BinaryTreeProblems.DFS.NodeReturningFromChildProblems;

import java.util.ArrayList;
import java.util.Arrays;


import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.BinaryTree.Node;

public class SerializeAndDeserializeATree {

    static ArrayList<String> serialize(Node node){
        ArrayList<String> list=new ArrayList<>();
        if(node==null){
             ArrayList<String> ans=new ArrayList<>();
             ans.add("n");
            return ans;
        }
        list.add(String.valueOf(node.value));
        list.addAll(serialize(node.left));
        list.addAll(serialize(node.right));
        return list;

    }
    
    static Node deserialize(ArrayList<String> list){
        if(list.size()==0){
            return null;
        }

        String value=list.remove(0);

        if("n".equals(value)){
            return null;
        }
        Node node=new Node(Integer.parseInt(value));
        node.left=deserialize(list);
        node.right=deserialize(list);
        return node;

    }
    ///serialisation and deserialisation by string 
 static String serializeString(Node node){
       String ans="";
        if(node==null){
             
            return "n,";
        }
        ans=ans+String.valueOf(node.value)+',';
        ans=ans+serializeString(node.left);
        ans=ans+serializeString(node.right);
        return ans;

    }
       static Node deserializeFromString(String encoded){
        String[] listArray=encoded.split(",");
        ArrayList<String> list=new ArrayList<>(Arrays.asList(listArray));
        return deserialize(list);
      

    }
   

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        int[] arr={1,2,3,4,5,6};
        bt.populateTree(arr);
        bt.printTree();
        System.out.println("=======");

        ArrayList<String> encoded=serialize(bt.root);
        System.out.println("encoded");
        System.out.println();
        System.out.println(encoded);
        System.out.println();
     
        Node root=deserialize(encoded);
        System.out.println("decoded");
        System.out.println();
        bt.printTree(root,0);
         System.out.println("=======");

        String encodedString=serializeString(bt.root);
        System.out.println("encoded String");
        System.out.println();
        System.out.println(encodedString);
        System.out.println();
     
        Node root2=deserializeFromString(encodedString);
        System.out.println("decoded");
        System.out.println();
        bt.printTree(root2,0);

    }
}