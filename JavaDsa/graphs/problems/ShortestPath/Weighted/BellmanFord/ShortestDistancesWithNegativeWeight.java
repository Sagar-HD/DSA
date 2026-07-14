package graphs.problems.ShortestPath.Weighted.BellmanFord;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ShortestDistancesWithNegativeWeight
 */
public class ShortestDistancesWithNegativeWeight {
    static int[] getShortestDistances(int[][] edges, int vertices, int source) {
        int[] shortestDistances = new int[vertices];
        Arrays.fill(shortestDistances, Integer.MAX_VALUE);
        shortestDistances[source] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];
                int wt = edge[2];
                if (shortestDistances[node1] != Integer.MAX_VALUE) {
                    if (shortestDistances[node1] + wt < shortestDistances[node2]) {
                        shortestDistances[node2] = shortestDistances[node1] + wt;
                    }
                }
            }
        }

        // relaxation done v-1 times to it covers all edges

        // now checking for negative cycle

        // if negative cycle exist relxation occurs in n th iteration
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int wt = edge[2];
            if (shortestDistances[node1] != Integer.MAX_VALUE) {
                if (shortestDistances[node1] + wt < shortestDistances[node2]) {
                    // negative cycle
                    return new int[vertices];
                }
            }
        }

        return shortestDistances;
    }

    public static void main(String[] args) {
        int vertices = 5;

        int[][] edges = {
                { 0, 1, 6 },
                { 0, 2, 7 },
                { 1, 2, 8 },
                { 1, 3, 5 },
                { 1, 4, -4 },
                { 2, 3, -3 },
                { 2, 4, 9 },
                { 3, 1, -2 },
                { 4, 0, 2 },
                { 4, 3, 7 }
        };

        int source = 0;
        int[] shortestDistances = getShortestDistances(edges, vertices, source);
        for (int i : shortestDistances) {
            System.out.print(i+" ");
        }

    }

}

/*
 * ============================================================================
 *                          BELLMAN - FORD ALGORITHM
 * ============================================================================
 *
 * PURPOSE
 * -------
 * Finds the shortest distance from ONE SOURCE to ALL OTHER VERTICES.
 *
 * Unlike Dijkstra, Bellman-Ford works even when the graph contains
 * NEGATIVE EDGE WEIGHTS.
 *
 * Time Complexity  : O(V * E)
 * Space Complexity : O(V)
 *
 *
 * ============================================================================
 * WHAT IS A NEGATIVE EDGE?
 * ============================================================================
 *
 * Normally, travelling from one place to another has a positive cost.
 *
 * Example:
 *
 *      Bangalore ----100----> Mysore
 *
 * Cost = +100
 *
 * But sometimes travelling can actually REDUCE the total cost.
 *
 * Real world examples:
 *
 * 1) Cashback
 *
 *      Buy Product A
 *      Get ₹200 cashback
 *
 * Edge weight = -200
 *
 * 2) Profit
 *
 *      Move goods from A to B
 *      Earn ₹50 profit
 *
 * Edge weight = -50
 *
 * 3) Currency Arbitrage
 *
 * Converting currencies may increase your money.
 * In graph problems this is modeled using negative weights.
 *
 * Negative simply means:
 *
 *      "Taking this edge reduces the total cost."
 *
 *
 * ============================================================================
 * WHAT IS RELAXATION?
 * ============================================================================
 *
 * Relaxation means:
 *
 *      "If I found a better(shorter) path, update it."
 *
 * Formula:
 *
 *      if(dist[u] + weight < dist[v])
 *          dist[v] = dist[u] + weight;
 *
 * Example:
 *
 * Current:
 *
 *      dist[B] = 15
 *
 * New path through A:
 *
 *      dist[A] = 5
 *
 *      A ----3----> B
 *
 * New cost = 5 + 3 = 8
 *
 * Since 8 < 15
 *
 * Update:
 *
 *      dist[B] = 8
 *
 * This update is called RELAXATION.
 *
 *
 * ============================================================================
 * WHY DOES BELLMAN-FORD RUN V-1 TIMES?
 * ============================================================================
 *
 * Suppose there are V vertices.
 *
 * Any shortest SIMPLE PATH can contain at most V-1 edges.
 *
 * Why?
 *
 * Because if a path uses V edges,
 * one vertex must repeat,
 * which means a cycle exists.
 *
 * A shortest path never needs to repeat vertices
 * (unless there is a negative cycle).
 *
 * Therefore,
 *
 * Every complete iteration allows shortest distances
 * to propagate ONE EDGE farther.
 *
 * After V-1 iterations,
 * every shortest path has had enough opportunities
 * to update all vertices.
 *
 *
 * ============================================================================
 * WHY DON'T WE USE A QUEUE OR PRIORITY QUEUE?
 * ============================================================================
 *
 * Bellman-Ford never decides
 * "Which node should I visit next?"
 *
 * Instead it simply says:
 *
 *      Repeat V-1 times:
 *          Relax EVERY EDGE.
 *
 * It does not care about order.
 *
 * Eventually every shortest path propagates naturally.
 *
 *
 * ============================================================================
 * WHY DOES DIJKSTRA FAIL FOR NEGATIVE EDGES?
 * ============================================================================
 *
 * Dijkstra makes one very important assumption:
 *
 *      "Once I remove a node with minimum distance
 *       from the priority queue,
 *       its answer is FINAL."
 *
 * This assumption is TRUE only when all edges
 * are NON-NEGATIVE.
 *
 *
 * Example:
 *
 *      A ----1----> B
 *       \
 *        \
 *         2
 *          \
 *           v
 *            C
 *             \
 *             -5
 *               \
 *                v
 *                 B
 *
 * Distances:
 *
 * A -> B = 1
 *
 * A -> C = 2
 *
 * C -> B = -5
 *
 * Dijkstra sees:
 *
 *      dist[B] = 1
 *      dist[C] = 2
 *
 * Since 1 is smaller,
 * it FINALIZES B.
 *
 * Later it discovers:
 *
 *      A -> C -> B
 *
 * Cost:
 *
 *      2 + (-5) = -3
 *
 * But B was already finalized.
 *
 * Therefore Dijkstra gives a wrong answer.
 *
 *
 * ============================================================================
 * WHY DOES BELLMAN-FORD STILL WORK?
 * ============================================================================
 *
 * Bellman-Ford NEVER finalizes a node.
 *
 * It keeps asking:
 *
 *      "Can this edge improve the answer?"
 *
 * Every edge gets another chance
 * during every iteration.
 *
 * So even if a better path appears later,
 * Bellman-Ford updates it.
 *
 * This is why negative edges are handled correctly.
 *
 *
 * ============================================================================
 * WHAT IS A NEGATIVE CYCLE?
 * ============================================================================
 *
 * Example:
 *
 *      A ----2----> B
 *      ^           |
 *      |           |
 *      1          -5
 *      |           |
 *      +-----------+
 *
 * Total cycle weight:
 *
 *      2 + (-5) + 1 = -2
 *
 * Every time we travel around this cycle:
 *
 * Cost decreases by 2.
 *
 * Example:
 *
 * First time:
 *      Cost = 0
 *
 * Second loop:
 *      Cost = -2
 *
 * Third loop:
 *      Cost = -4
 *
 * Fourth loop:
 *      Cost = -6
 *
 * ...
 *
 * There is NO SHORTEST PATH,
 * because we can always make the path cheaper
 * by looping once more.
 *
 *
 * ============================================================================
 * HOW IS A NEGATIVE CYCLE DETECTED?
 * ============================================================================
 *
 * After V-1 iterations,
 * every shortest distance should already be finalized.
 *
 * Therefore,
 *
 * One MORE iteration should NOT change anything.
 *
 * If even one edge can still be relaxed:
 *
 *      dist[u] + weight < dist[v]
 *
 * then a negative cycle exists.
 *
 * Because the only reason distances can keep improving
 * after V-1 iterations
 * is that some negative cycle is reducing the cost forever.
 *
 *
 * ============================================================================
 * SUMMARY
 * ============================================================================
 *
 * Dijkstra:
 * ----------
 * ✔ Fast
 * ✔ Uses Priority Queue
 * ✔ Finalizes nodes
 * ✘ Cannot handle negative edges
 *
 *
 * Bellman-Ford:
 * -------------
 * ✔ Slower
 * ✔ Relaxes every edge repeatedly
 * ✔ Handles negative edges
 * ✔ Detects negative cycles
 *
 * ============================================================================
 */