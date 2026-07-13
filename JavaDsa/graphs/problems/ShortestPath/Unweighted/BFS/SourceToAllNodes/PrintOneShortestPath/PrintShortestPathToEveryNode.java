package graphs.problems.ShortestPath.Unweighted.BFS.SourceToAllNodes.PrintOneShortestPath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class PrintShortestPathToEveryNode {
    static void printShortestPathToAllNode(ArrayList<ArrayList<Integer>> adjList,int source){
      boolean[] visited=new boolean[adjList.size()];
      int[] parent=new int[adjList.size()] ;
      for(int i=0;i<adjList.size();i++){
        parent[i]=-1;
      }
      Queue<Integer> q =new LinkedList<>();
      q.offer(source);
      visited[source]=true;
      parent[source]=source;
      while(!q.isEmpty()){
        int cur=q.poll();
        for(int neigbhour:adjList.get(cur)){
            if(!visited[neigbhour]){
                visited[neigbhour]=true;
                parent[neigbhour]=cur;
                q.offer(neigbhour);
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
        int n=4;
        int[][] edges={
            {0,1},
            {0,2},
            {1,3},
            {2,3}
        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(n, edges);
        printShortestPathToAllNode(adjList, 0);

    }
    
}
