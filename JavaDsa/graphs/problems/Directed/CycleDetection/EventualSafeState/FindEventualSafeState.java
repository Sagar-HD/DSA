package graphs.problems.Directed.CycleDetection.EventualSafeState;

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

//in this if a node is not safe we return by marking it as false, we will not proceed with neigbours it will handled by outer loop in caller method
static boolean DfsCheckCycleAndMarkSafe(ArrayList<ArrayList<Integer>> adjList, boolean[] safeNodes,boolean[] visited, boolean[] pathVisited,int source){
    visited[source]=true;
    pathVisited[source]=true;

    for(int neighbour : adjList.get(source)){
        if(!visited[neighbour]){
            //if any one neighbour is not safe we return false and remove this from path visited
            if(DfsCheckCycleAndMarkSafe(adjList, safeNodes, visited, pathVisited, neighbour)==false){
                     pathVisited[source] = false;  
                return false;
            }

        }
        //this makes the neigbour already in path
        else if(pathVisited[neighbour]){
                 pathVisited[source] = false;  
            return false;
            

        }
        //if its not in path but still visited then it was already check check its safe or not , if safe ignore and move to next neigbhour
             else if (!safeNodes[neighbour]) {   
        pathVisited[source] = false;
        return false;
    }
    }
    safeNodes[source]=true;
    pathVisited[source]=false;
    return true;

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