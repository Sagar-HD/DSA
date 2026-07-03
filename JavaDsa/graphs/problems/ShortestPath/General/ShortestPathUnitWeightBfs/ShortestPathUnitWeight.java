package graphs.problems.ShortestPath.General.ShortestPathUnitWeightBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;
import javafx.util.Pair;

public class ShortestPathUnitWeight {
    static ArrayList<Integer> getShortestDistances(ArrayList<ArrayList<Integer>> adjList,int source){
        ArrayList<Integer> distances=new ArrayList<>();
        for(int i=0;i<adjList.size();i++){
            distances.add(Integer.MAX_VALUE);
        }
        boolean[] visited=new boolean[adjList.size()];
      
          
                visited[source]=true;
                distances.set(source, 0);
                bfs(adjList, source, distances, visited);
          

        

        return distances;
    }

    static void bfs(ArrayList<ArrayList<Integer>> adjList,int source,ArrayList<Integer> distances,boolean[] visited){
    
        Queue<Integer> q=new LinkedList<>();
             q.offer(source);
        while(!q.isEmpty()){
            int cur=q.poll();
            for(int neighbour:adjList.get(cur)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                    distances.set(neighbour,distances.get(cur)+1);
                }
            }
        }

    }
    public static void main(String[] args) {
        int nodes=7;
        int[][]  edges={
            {0,1},
            {1,2},
            {2,4},
            {4,6},
            {6,2}

        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(nodes, edges);
        int source=0;
        ArrayList<Integer> distances=getShortestDistances(adjList, source);
        System.out.println(distances);
        
    }
    
}
