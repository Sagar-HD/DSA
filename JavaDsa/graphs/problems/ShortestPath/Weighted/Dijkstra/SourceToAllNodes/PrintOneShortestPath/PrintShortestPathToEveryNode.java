package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToAllNodes.PrintOneShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class PrintShortestPathToEveryNode {
    static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
    }
    static void printShortestPathToAllNodes( ArrayList<ArrayList<Pair>> adjList,int source){
        int[] shortestDistances=new int[adjList.size()];
        for(int i=0;i<adjList.size();i++){
            shortestDistances[i]=Integer.MAX_VALUE;
        }
        int[] parent=new int[adjList.size()];
          for(int i=0;i<adjList.size();i++){
            parent[i]=-1;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));
        shortestDistances[source]=0;
        parent[source]=source;
        q.offer(new Pair(source, 0));
        while(!q.isEmpty()){
            Pair cuPair=q.poll();
            int curNode=cuPair.node;
            int distanceTillCur=cuPair.weight;
            if(distanceTillCur>shortestDistances[curNode]) continue;
            
            for(Pair neighbour: adjList.get(curNode)){
                int neigbhourNode=neighbour.node;
                int neighbourDistance=neighbour.weight;

                int totalDistance=distanceTillCur+neighbourDistance;

             

                if(totalDistance<shortestDistances[neigbhourNode]){
                    System.out.println("enquued "+neigbhourNode+" with weight"+ totalDistance);
                    q.offer(new Pair(neigbhourNode, totalDistance));
                    shortestDistances[neigbhourNode]=totalDistance;
                    parent[neigbhourNode]=curNode;
                }


            }


        }
           for(int node=0;node<adjList.size();node++){
        if(parent[node]!=-1){

            int nodeToBackCheck=node;
           ArrayList<Integer> path=new ArrayList<>();
            while(parent[nodeToBackCheck]!=nodeToBackCheck){
                path.add(nodeToBackCheck);
                nodeToBackCheck=parent[nodeToBackCheck];
            }
            path.add(nodeToBackCheck);
            Collections.reverse(path);
            System.out.println("path to node "+node +" is "+path);


        }

      }

    }
    public static void main(String[] args) {
        int n=5;
        int[][] edges={
            {0,1,4},
            {0,2,1},
            {0,3,2},
            {2,3,5},
            {3,4,3},
            {1,4,1}

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
        int source=0;
        printShortestPathToAllNodes(adjList, source);

    }
    
}
