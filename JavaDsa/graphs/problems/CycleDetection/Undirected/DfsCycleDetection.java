package graphs.problems.CycleDetection.Undirected;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;

public class DfsCycleDetection {

    //notice one thing iam marking it as visited and then calling function but u can also call the functiom
    // and then mark node as visited then check its neighbour
    //but in bfs we can mark node as while processing it we must mark when it has been explored only
    // now if we explore a node then immediatly we are processing it so its not a problem
    //but in bfs exploring is not processing it neigbhours so mark while exploring only to avoid other node accidently visiting the visited node
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adjList){
        boolean[] visited=new boolean[adjList.size()];
        //this loop takes cares of all components in graph
         for(int i=0;i<adjList.size();i++){
            if(!visited[i]){
                visited[i]=true;
                //passing parent as -1 it respresnt no parent bcs its the source
           if(helper(adjList,visited,i,-1)){
            return true;
           }
        }
        }
        return false;

    }
    static boolean helper(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,int source,int parent){
        for(int neighbour:adjList.get(source)){
            if(!visited[neighbour]){
                visited[neighbour]=true;

                if(helper(adjList, visited, neighbour,source)){
                    return true;
                }
            }
            else{
                if(neighbour!=parent){
                     
                    return true;
 
                }

            }

        }
        return false;
       
    }

     public static void main(String[] args) {

        // Test Case 1: No Cycle
        // int vertices = 5;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // {2, 3},
        // {3, 4}
        // };

        // Test Case 2: Simple Cycle
        // int vertices = 4;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // {2, 3},
        // {3, 0}
        // };

        // Test Case 3: Triangle Cycle
        // int vertices = 3;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // {2, 0}
        // };

        // Test Case 4: Disconnected Graph (one component has cycle)
        // int vertices = 7;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // {2, 0}, // cycle
        // {3, 4},
        // {5, 6}
        // };

        // Test Case 5: Disconnected Graph (no cycle)
        // int vertices = 6;
        // int[][] edges = {
        // {0, 1},
        // {1, 2},
        // {3, 4}
        // };

        // Test Case 6: Single Vertex
        // int vertices = 1;
        // int[][] edges = {};

        // Test Case 7: Two Vertices with One Edge
        // int vertices = 2;
        // int[][] edges = {
        // {0, 1}
        // };

        // Test Case 8: Complex Graph with Multiple Cycles
        int vertices = 8;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 }, // cycle 1
                { 2, 3 },
                { 3, 4 },
                { 4, 5 },
                { 5, 3 }, // cycle 2
                { 6, 7 }
        };

        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(vertices, edges);

        System.out.println(adjList);

        System.out.println(hasCycle(adjList));
    }
}