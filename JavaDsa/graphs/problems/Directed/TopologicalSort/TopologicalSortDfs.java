package graphs.problems.Directed.TopologicalSort;
//for topological sort graph must be directed and acyclic , DAG 
//no cycle bcs its all about dependencies it their is cycle in dependies no one will start everyone will for each other
// directed bcs  without direction we cant say  who should come before eho or if we assume both way it will be like cycle
//if we perform dfs for a directed graph with cycle it will ignore the cycle and give wrong answer
//dfs naturally goes deep visit deep of a neigbour then to another neigbhour 
// DFS naturally explores one dependency chain completely before returning.
// A node is pushed onto the stack ONLY AFTER all of its outgoing neighbours

//if there is cycle the dfs is designed to ignore the cycle bcs the goal was just to visit all nodes once
//remember we are giving only 1 possible ordering there may be many orderding
// many ordering based on connected components order we traverse or the order of neigbhour we traverse
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graphs.representation.GraphBuildUtil;

public class TopologicalSortDfs {
    static List<Integer> getOrder(ArrayList<ArrayList<Integer>> adjList){
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        boolean[] visited=new boolean[adjList.size()];
        int numberOfNodes=adjList.size();
        for(int node=0;node<numberOfNodes;node++){
            if(!visited[node]){
                dfs(adjList,stack,visited,node);
            }
        }
        //after travesing all connected components the nodes will be added in a order to stack
        // order is such that only visiting all neigbours the particular node will be added to stack
        // when we start poping we get node to be visited first then all which are dependent to it
        while(!stack.isEmpty()){
            int node=stack.pop();
            ans.add(node);
        }

        return ans;

    }



    private static void dfs(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int node) {
        visited[node]=true;
        // Finish all dependencies first.
        for(int neighbour:adjList.get(node)){
            if(!visited[neighbour]){
                dfs(adjList, stack, visited, neighbour);
            }
        }
        // Every node below the current node in this stack
        // has already been completely processed.
        // Current node is finished,
        // so add it to the finishing-order stack.
        stack.push(node);
        
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
        List<Integer> topolgicalOrder=getOrder(adjList);
        for(Integer node : topolgicalOrder){
            System.out.println(node);
        }

    }
    
}
