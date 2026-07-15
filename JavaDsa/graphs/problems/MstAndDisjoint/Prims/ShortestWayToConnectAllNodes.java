package Prims;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ShortestWayToConnectAllNodes {
    static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    }
    static class QueuePair{
        int node;
        int weight;
        int parent;
        public QueuePair(int node, int weight,int parent) {
            this.node = node;
            this.weight = weight;
            this.parent=parent;
        }

    }
    static int[][] getMst(ArrayList<ArrayList<Pair>> adjList){
        int[][] mst=new int[adjList.size()-1][3];
        boolean[] visited=new boolean[adjList.size()];
        PriorityQueue<QueuePair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));
        //starting from 0 can start from any node
        q.offer(new QueuePair(0, 0,-1));
        
        int edgeIndex=0;
        while(!q.isEmpty()){
            QueuePair cur=q.poll();
            int curNode=cur.node;
            int curParent=cur.parent;
            int curWeight=cur.weight;
            if(visited[curNode])continue;
            visited[curNode]=true;

            if(curParent!=-1){
                int[] edge=new int[3];
            edge[0]=curParent;
            edge[1]=curNode;
            edge[2]=curWeight;
             mst[edgeIndex]=edge;
             
             edgeIndex++;

            }
            for(Pair neigbhour:adjList.get(curNode)){
                int neighbourNode=neigbhour.node;
                int neighbourWeight=neigbhour.weight;
                if(!visited[neighbourNode]){
                    q.offer(new QueuePair(neighbourNode, neighbourWeight, curNode));
                }
            }

        }

        return mst;

    }
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

        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());

        }
        for(int i=0;i<edges.length;i++){
            int node1=edges[i][0];
            int node2=edges[i][1];
            int weight=edges[i][2];
            adjList.get(node1).add(new Pair(node2, weight));
             adjList.get(node2).add(new Pair(node1, weight));
        }
        int[][] mst=getMst(adjList);
        for(int i=0;i<mst.length;i++){
            for(int j=0;j<mst[0].length;j++){
                System.out.print(mst[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
