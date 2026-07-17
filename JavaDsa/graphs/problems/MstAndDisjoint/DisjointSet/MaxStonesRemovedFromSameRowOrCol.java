package DisjointSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * MaxStonesRemovedFromSameRowOrCol
 */
public class MaxStonesRemovedFromSameRowOrCol {
    //disjoint set datastructure
   static class DisjointSet{
    int[] parent;
    int[] size;
    DisjointSet(int n){
        this.parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }
        this.size=new int[n+1];
        Arrays.fill(size,1);
    }
 public int find(int n){
    if(n==parent[n]){
        return n;
    }
    return parent[n]=find(parent[n]);

 }

 public void union(int node1,int node2){
    int parent1=find(node1);
    int parent2=find(node2);
    if(parent1==parent2)return;
  
    if(size[parent1]>size[parent2]){
        parent[parent2]=parent1;
        size[parent1]+=size[parent2];


    }
    else{
        parent[parent1]=parent2;
        size[parent2]+=size[parent1];  
    }

 }



}
//

//method to find max stones can be removed , no of stones - noOfComponents bcs at each component we can remove n-1 nodes from that component
 public static int removeStones(int[][] stones) {
    
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<stones.length;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
             maxCol=Math.max(maxCol,stones[i][1]);

        }
        DisjointSet dsj=new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer> map=new HashMap<>();
         for(int i=0;i<stones.length;i++){
           int stoneRowNode=stones[i][0];
           int stoneColNode=stones[i][1]+maxRow+1;

           dsj.union(stoneRowNode,stoneColNode);
           map.put(stoneRowNode,1);
           map.put(stoneColNode,1);

        }
        int noOfComponents=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(dsj.find(entry.getKey())==entry.getKey()){
                noOfComponents++;
            }
        }
        int totalStones=stones.length;

        return totalStones-noOfComponents;


        
    }
    public static void main(String[] args) {
        int[][] stones={
        {0,0},
        {0,1},
        {1,0},
        {1,2},
        {2,1},
        {2,2}
        };
        System.out.println(removeStones(stones));
      
    }

}