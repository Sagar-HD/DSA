package graphs.problems.ShortestPath.Unweighted.BFS.SourceToAllNodes.CountShortestPaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;
//observe how we can not just calculate no of ways to destinantion by counting when a node reaches them usinf 
/*    if(!visited[neighbour]){
              visit..
        }
       else{
            if(distance==distance[neighbour]){
                ways=ways+1;
            }
       }

       the above thing we cant do bcs we cant simple do ways+1 bcs its parent may have n ways to reach
       so we see ways to parent and add them
*/

public class NoOfShortestPathsToEveryNode {
    static ArrayList<Integer> getNoOfShortestPathToALL(ArrayList<ArrayList<Integer>> adjList, int source) {
        ArrayList<Integer> noOfShortestPaths = new ArrayList<>();
        ArrayList<Integer> shortestDistances = new ArrayList<>();
        // add 0 paths at starting
        for (int i = 0; i < adjList.size(); i++) {
            noOfShortestPaths.add(0);

        }
        // marking all as infinite distance
        for (int i = 0; i < adjList.size(); i++) {
            shortestDistances.add(Integer.MAX_VALUE);

        }
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source] = true;
        noOfShortestPaths.set(source, 1);
        shortestDistances.set(source, 0);
     
        while (!q.isEmpty()) {
          
           
           
                int cur = q.poll();

                for (int neigbour : adjList.get(cur)) {
                    if (!visited[neigbour]) {
                        visited[neigbour]=true;
                        shortestDistances.set(neigbour, shortestDistances.get(cur) + 1);
                        noOfShortestPaths.set(neigbour, noOfShortestPaths.get(cur));
                        q.offer(neigbour);
                    } else if (shortestDistances.get(cur) + 1 == shortestDistances.get(neigbour)) {
                        noOfShortestPaths.set(
                                neigbour,
                                noOfShortestPaths.get(neigbour) + noOfShortestPaths.get(cur));
                    }

                }
            
           
         

        }
        return noOfShortestPaths;

    }

    public static void main(String[] args) {
        int nodes = 10;
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 1, 4 },
                { 2, 4 },
                { 2, 5 },
                { 3, 6 },
                { 4, 6 },
                { 4, 7 },
                { 5, 7 },
                { 6, 8 },
                { 6, 9 },
                { 7, 9 }
        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(nodes, edges);
        System.out.println(getNoOfShortestPathToALL(adjList, 0));
    }

}
