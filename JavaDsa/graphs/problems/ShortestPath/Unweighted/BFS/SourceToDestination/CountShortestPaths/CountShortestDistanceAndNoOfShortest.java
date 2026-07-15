package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.CountShortestPaths;

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
public class CountShortestDistanceAndNoOfShortest {

    static class Pair {
        private int shortestDistance;
        private int noOfways;

        public Pair(int shortestDistance, int noOfways) {
            this.shortestDistance = shortestDistance;
            this.noOfways = noOfways;
        }

    }

    static Pair getShortestDistanceAndNoOfWays(ArrayList<ArrayList<Integer>> adjList, int source, int destinantion) {
        int[] shortestDistance = new int[adjList.size()];
        for (int i = 0; i < shortestDistance.length; i++) {
            shortestDistance[i] = Integer.MAX_VALUE;

        }
        int[] noOfWays = new int[adjList.size()];

        Queue<Integer> q = new LinkedList<>();

        shortestDistance[source] = 0;
        noOfWays[source] = 1;
        q.offer(source);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neigbhour : adjList.get(cur)) {
                if (shortestDistance[cur] + 1 < shortestDistance[neigbhour]) {

                    shortestDistance[neigbhour] = shortestDistance[cur] + 1;
                    noOfWays[neigbhour] = noOfWays[cur];
                    q.offer(neigbhour);

                } else {
                    if (shortestDistance[cur] + 1 == shortestDistance[neigbhour]) {
                        noOfWays[neigbhour] = noOfWays[neigbhour] + noOfWays[cur];
                    }
                }

            }

        }

        if (shortestDistance[destinantion] != Integer.MAX_VALUE) {
            Pair ans = new Pair(shortestDistance[destinantion], noOfWays[destinantion]);
            return ans;
        }

        return new Pair(-1, 0);

    }

    public static void main(String[] args) {
        int nodes = 8;

        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 3 },
                { 1, 4 },
                { 2, 5 },
                { 3, 6 },
                { 4, 6 },
                { 5, 6 },
                { 6, 7 }
        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(nodes, edges);
        Pair ans = getShortestDistanceAndNoOfWays(adjList, 0, 7);
        System.out.println("shortest distance " + ans.shortestDistance);
        System.out.println("no of ways" + ans.noOfways);
    }

}
