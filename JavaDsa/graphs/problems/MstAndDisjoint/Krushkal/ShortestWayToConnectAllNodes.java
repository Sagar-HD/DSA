package Krushkal;

import java.util.Arrays;

import DisjointSet.DisjointSet;

public class ShortestWayToConnectAllNodes {
    
    public static void main(String[] args) {
        int n=5;
        int[][] edges={
          {0,1,2},
          {0,2,2},
          {2,1,1},
          {2,4,2},
          {2,3,2},
          {4,3,1}

        };
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));//custom comparator to sort bases on 2 nd index
        int[][] mst=new int[n-1][3];//n-1 bcs in mst no cycle it can have only n-1 edges tp connect all
        DisjointSet dsj=new DisjointSet(n);
        int mstEdgeCount=0;

        for(int[] edge :edges){
            int node1=edge[0];
            int node2=edge[1];
            int weight=edge[2];

            if(!dsj.isConnected(node1, node2)){
                mst[mstEdgeCount][0]=node1;
                mst[mstEdgeCount][1]=node2;
                 mst[mstEdgeCount][2]=weight;
                 dsj.unionBySize(node1, node2);
                 mstEdgeCount++;


            }



        }
     
          for(int i=0;i<mst.length;i++){
            for(int j=0;j<mst[0].length;j++){
                System.out.print(mst[i][j]+" ");
            }
            System.out.println();
        }
        

    }
    
}
