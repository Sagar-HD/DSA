package graphs.problems.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;


public class TopologicalSortBfsKahnsAlgo {


 static List<Integer> getTopologicOrder(ArrayList<ArrayList<Integer>> adjList){
     List<Integer> ans=new ArrayList<>();
     int[] indegree=new int[adjList.size()];
     for(int node=0;node<adjList.size();node++){
        for(int outEdge : adjList.get(node)){
            indegree[outEdge]++;
        }
     }
     Queue<Integer> q=new LinkedList<>();

     for(int node=0;node<adjList.size();node++){
        if(indegree[node]==0){
            q.offer(node);

        }
     }
     while(!q.isEmpty()){
        Integer node=q.poll();
        ans.add(node);
        for(int outEdge:adjList.get(node)){
            indegree[outEdge]--;
        }
        for(int neighbour : adjList.get(node)){
            if(indegree[neighbour]==0){
                q.offer(neighbour);
            }
        }
        //we could have done this both removing indergree and adding node with 0 indegree in same loop
        //added 2 loops for redabilty
     }
     return ans;
    
 }
    public static void main(String[] args) {
         int v=12;
        int[][] edges={
            {0,1},
            {1,2},
            {2,3},
            {3,4},
            {4,6},
            {6,7},
            {4,5},
            {5,6},
            {8,1},
            {8,9},
            {9,10},
            {11,9}

        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildDirectedGraph(v, edges);
        List<Integer> topologicalOrder=getTopologicOrder(adjList);
        System.out.println(topologicalOrder);
    }

    
}