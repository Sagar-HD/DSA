package graphs.problems.Directed;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;

public class FindEventualSafeState {




static boolean[] giveSafeNodes(ArrayList<ArrayList<Integer>> adjList){
    boolean[] safeNodes=new boolean[adjList.size()];
    boolean[] visited=new boolean[adjList.size()];
    boolean[] pathVisited=new  boolean[adjList.size()];

    for(int node=0;node<adjList.size();node++){
        if(!visited[node]){
           DfsCheckCycleAndMarkSafe(adjList, safeNodes, visited, pathVisited,node);
        }

    }

    return safeNodes;

}


static boolean DfsCheckCycleAndMarkSafe(ArrayList<ArrayList<Integer>> adjList, boolean[] safeNodes,boolean[] visited, boolean[] pathVisited,int source){
    visited[source]=true;
    pathVisited[source]=true;

    for(int neighbour : adjList.get(source)){
        if(!visited[neighbour]){
            if(DfsCheckCycleAndMarkSafe(adjList, safeNodes, visited, pathVisited, neighbour)){
                return true;
            }

        }
        else if(pathVisited[neighbour]){

            return true;
            

        }
    }
    safeNodes[source]=true;
    pathVisited[source]=false;
    return false;

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
            {10,8},
            {11,9}

        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildDirectedGraph(v, edges);
        boolean[] safeNodes=giveSafeNodes(adjList);
        for(int i=0;i<safeNodes.length;i++){
            if(safeNodes[i]){
           System.out.println(i);
            }
        }

    }

    
}