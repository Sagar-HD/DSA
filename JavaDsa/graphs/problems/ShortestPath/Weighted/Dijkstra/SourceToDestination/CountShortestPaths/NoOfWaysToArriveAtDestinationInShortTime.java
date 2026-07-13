package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToDestination.CountShortestPaths;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * NoOfWaysToArriveAtDestinationInShortTime
 
 */
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

public class NoOfWaysToArriveAtDestinationInShortTime {
      public static class Pair{
    private int node;
    private long time;

    public Pair(int node,long time){
        this.node=node;
        this.time=time;
    }

    }
      public static int getWays(ArrayList<ArrayList<Pair>> adjList) {
        long[] shortestDistances = new long[adjList.size()];
        int MOD = 1_000_000_007;
        for (int i = 0; i < shortestDistances.length; i++) {
            shortestDistances[i] = Long.MAX_VALUE;
        }
        int[] ways = new int[adjList.size()];

        PriorityQueue<Pair> q = new PriorityQueue<>((pair1, pair2) -> Long.compare(pair1.time, pair2.time));
        q.offer(new Pair(0, 0));
        shortestDistances[0] = 0;
        ways[0] = 1;
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curNode = cur.node;
            long timeToCur = cur.time;

            if (timeToCur > shortestDistances[curNode])
                continue;

            for (Pair neighbour : adjList.get(curNode)) {
                int neighbourNode = neighbour.node;
                long extraTime = neighbour.time;
                long totalTime = timeToCur + extraTime;
                if (totalTime < shortestDistances[neighbourNode]) {
                    shortestDistances[neighbourNode] = totalTime;
                    ways[neighbourNode] = ways[curNode];
                    q.offer(new Pair(neighbourNode, totalTime));

                } else if (totalTime == shortestDistances[neighbourNode]) {
                    ways[neighbourNode] = (ways[neighbourNode] + ways[curNode]) % MOD;

                }

            }

        }
        return ways[adjList.size() - 1];

    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                { 0, 6, 7 },
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 1, 3, 3 },
                { 6, 3, 3 },
                { 3, 5, 1 },
                { 6, 5, 1 },
                { 2, 5, 1 },
                { 0, 4, 5 },
                { 4, 6, 2 }

        };

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int node1 = roads[i][0];
            int node2 = roads[i][1];
            int time = roads[i][2];
            adjList.get(node1).add(new Pair(node2, time));
            adjList.get(node2).add(new Pair(node1, time));
        }

        System.out.println(getWays(adjList));

    }

}

