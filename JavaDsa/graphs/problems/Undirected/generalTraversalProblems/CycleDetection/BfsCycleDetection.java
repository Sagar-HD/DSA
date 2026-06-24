package graphs.problems.Undirected.generalTraversalProblems.CycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class BfsCycleDetection {
    static class Pair {
        int value;
        int parent;

        public Pair(int value, int parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    // this method not handle disconnected graph , if we want that just loop over
    // vertices if not visited call this cycle method to check homw many has cycle
    static boolean hasCycle(ArrayList<ArrayList<Integer>> adjList) {
        Queue<Pair> q = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size()];
        visited[0] = true;
        q.offer(new Pair(0, -1));
        while (!q.isEmpty()) {
            Pair curNode = q.poll();
            for (int neighbour : adjList.get(curNode.value)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.offer(new Pair(neighbour, curNode.value));
                } else {
                    if (neighbour != curNode.parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean hasCycleCompleteGraph(ArrayList<ArrayList<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                Queue<Pair> q = new LinkedList<>();

                visited[i] = true;
                q.offer(new Pair(i, -1));
                while (!q.isEmpty()) {
                    Pair curNode = q.poll();
                    for (int neighbour : adjList.get(curNode.value)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            q.offer(new Pair(neighbour, curNode.value));
                        } else {
                            if (neighbour != curNode.parent) {
                                return true;
                            }
                        }
                    }
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