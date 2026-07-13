package graphs.problems.TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import graphs.representation.GraphBuildUtil;

//the question is find topo sort
//if topo sort not possible return empty array
//here we should do cycle detection + topo ordering
public class CourseSchedulingIIDfs {
    static List<Integer> getOrder(ArrayList<ArrayList<Integer>> adjList) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[adjList.size()];
        boolean[] pathVisited = new boolean[adjList.size()];
        for (int node = 0; node < adjList.size(); node++) {
            if (!visited[node]) {
                if (cycleCheckAndTopoSort(adjList, visited, pathVisited, node, order)) {
                    return new ArrayList<>();
                }

            }
        }
        //we need to reverse bcs we added the dependecy after processing all its child
        Collections.reverse(order);
        return order;

    }

    static boolean cycleCheckAndTopoSort(ArrayList<ArrayList<Integer>> adjList, boolean[] visited,
            boolean[] pathVisited, int node, List<Integer> order) {
                visited[node]=true;
                pathVisited[node]=true;
                for(int neighbour : adjList.get(node)){
                    if(!visited[neighbour]){
                        if(cycleCheckAndTopoSort(adjList, visited, pathVisited, neighbour, order)){
                            return true;
                        }
                    }
                    else if(pathVisited[neighbour]){
                     return true;
                    }
                }
                pathVisited[node]=false;
         //after processing all his neighbours only iam adding him to order 
         order.add(node);
        return false;
    }

    public static void main(String[] args) {
        int v = 12;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 6 },
                { 6, 7 },
                { 4, 5 },
                { 5, 6 },
                { 8, 1 },
                { 8, 9 },
                { 9, 10 },
                { 11, 9 }

        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildDirectedGraph(v, edges);
        List<Integer> topolgicalOrder = getOrder(adjList);
        System.out.println(topolgicalOrder);
      
         

    }

}
