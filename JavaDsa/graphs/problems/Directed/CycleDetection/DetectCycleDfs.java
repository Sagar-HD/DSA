package graphs.problems.Directed.CycleDetection;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;

public class DetectCycleDfs {
    static boolean helper(ArrayList<ArrayList<Integer>> adjList,boolean[] pathVisited,boolean[] visited,int source){
        pathVisited[source]=true;
        visited[source]=true;
        for(int neighbour : adjList.get(source)){
            //doing dfs for neigbour only if its not visited totally not only in path
            //bcs if we had visited once and not in my path then it means it has no cycle
            if(!visited[neighbour]){
                if(helper(adjList, pathVisited,visited, neighbour)){
                    return true;
                }
            }
            else if(pathVisited[neighbour]){
                //if path is visited we must check if its also visited in my path if then return cycle true
                //if its visited overal but not visited in my path we can just ignore bcs that path has no cycle and doesnt come in my path
                return true;

            }
        }
       pathVisited[source]=false;


      return false;
    }


    static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited=new boolean[adjList.size()];
        boolean[] pathVisited=new boolean[adjList.size()];
        for(int node=0;node<adjList.size();node++){
            if(!visited[node]){
                if(helper(adjList, pathVisited,visited, node)){
                    return true;
                }
            }
        }

        return false;

    }
    public static void main(String[] args) {
        int v=11;
        //1 based graph 
        int[][] edges={
            {1,2},
            {2,3},
            {3,4},
            {4,5},
            {5,6},
            {4,7},
            {7,5},
            {8,9},
            {9,10},
            {10,8},
            {8,2}


        };
        //this gives 0 node also included anyway it will be not connected to anyone so it doest create problem
        //in checking cycle also we will consider 0 it will just act as an signle connected component disconnected grom graph with no cycle
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildDirectedGraph(v, edges);
        System.out.println(checkCycle(adjList));
        
    }
    
}
