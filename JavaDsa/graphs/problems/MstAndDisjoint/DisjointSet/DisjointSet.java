package DisjointSet;

import java.util.Arrays;

/**
 * DisjointSet
 */
//implementation is very easy no need of explaination
//works for both 0 and 1 based graphs 

public class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int[] size;
    public DisjointSet(int nOOfNodes) {
        this.parent=new int[nOOfNodes+1];
        this.rank=new int[nOOfNodes+1];
        this.size=new int[nOOfNodes+1];
            Arrays.fill(rank, 0);
            Arrays.fill(size, 1);
            for(int i=0;i<nOOfNodes+1;i++){
                parent[i]=i;
            }
    }


    public int getUltimateParent(int node){
        if(node>=0 && node<parent.length){
      if(parent[node]==node){
        return node;
      }
      return parent[node]=getUltimateParent(parent[node]);
    }else{
        
      throw new RuntimeException("invalid node for disjoint");
    }

    }

    public boolean isConnected(int node1,int node2){
        if((node1<parent.length &&node1>=0 )&& (node2<parent.length && node2>=0)){
        return getUltimateParent(node1)==getUltimateParent(node2);
        }
        return false;
    }
    
    public boolean unionByRank(int node1,int node2){
        if((node1<parent.length &&node1>=0 )&& (node2<parent.length && node2>=0)){
        int ultimateParent1=getUltimateParent(node1);
        int ultimateParent2=getUltimateParent(node2);
         if (ultimateParent1 == ultimateParent2)return false;
        if(rank[ultimateParent1]>rank[ultimateParent2]){
            parent[ultimateParent2]=ultimateParent1;
            
        }
        else if(rank[ultimateParent2]>rank[ultimateParent1]){
            parent[ultimateParent1]=ultimateParent2;
        
        }
        else{
            parent[ultimateParent2]=ultimateParent1;
            rank[ultimateParent1]++;
        }
        return true;
        }
        else{
            System.out.println("nodes out of range");
            return false;
        }


    }
     public boolean unionBySize(int node1,int node2){
        if((node1<parent.length &&node1>=0 )&& (node2<parent.length && node2>=0)){
        int ultimateParent1=getUltimateParent(node1);
        int ultimateParent2=getUltimateParent(node2);
        if (ultimateParent1 == ultimateParent2)return false;
        if(size[ultimateParent1]>size[ultimateParent2]){
            parent[ultimateParent2]=ultimateParent1;
            size[ultimateParent1]+=size[ultimateParent2];
        }
        else{
              parent[ultimateParent1]=ultimateParent2;
            size[ultimateParent2]+=size[ultimateParent1];
        }
       return true;
        }
        else{
            System.out.println("nodes out of range");
            return false;
        }
     


    }

       public int getSizeOfComponent(int nodeInComponent){
            if(nodeInComponent>=0 && nodeInComponent<size.length){
                int ultimateParent=getUltimateParent(nodeInComponent);
                return size[ultimateParent];
            }
            return -1;
        }
    public static void main(String[] args) {
        DisjointSet djsSize=new DisjointSet(5);
        djsSize.unionBySize(0, 1);
        System.out.println(djsSize.isConnected(0,2));
         djsSize.unionBySize(1, 2);
     System.out.println(djsSize.isConnected(0,2));
     ////
       DisjointSet djsRank=new DisjointSet(5);
       djsRank.unionByRank(0, 2);
       djsRank.unionByRank(3, 5);
       djsRank.unionByRank(3, 4);
       System.out.println(djsRank.isConnected(2, 3));
       djsRank.unionByRank(0, 4);
        System.out.println(djsRank.isConnected(2, 3));
        
    }

    
}