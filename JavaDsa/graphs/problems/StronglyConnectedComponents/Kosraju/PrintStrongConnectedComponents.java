package graphs.problems.StronglyConnectedComponents.Kosraju;

import java.util.ArrayList;
import java.util.Stack;

import graphs.representation.GraphBuildUtil;

/**
 * PrintStrongConnectedComponents
 */
public class PrintStrongConnectedComponents {
    static void dfs(ArrayList<ArrayList<Integer>> adjList, Stack<Integer> finishingOrder, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {
                dfs(adjList, finishingOrder, visited, neighbour);
            }
        }
        finishingOrder.push(node);

    }

    static void sccDfsPrint(ArrayList<ArrayList<Integer>> revAdjList, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbour : revAdjList.get(node)) {
            if (!visited[neighbour]) {
                sccDfsPrint(revAdjList, visited, neighbour);
            }
        }

    }

    static void printScc(ArrayList<ArrayList<Integer>> adjList) {
        Stack<Integer> finishingOrder = new Stack<>();
        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs(adjList, finishingOrder, visited, i);
            }
        }
        // reversing graph or tranpose of graph
        ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            revAdjList.add(new ArrayList<>());
        }
        for (int node = 0; node < adjList.size(); node++) {
            for (int neighbour : adjList.get(node)) {
                revAdjList.get(neighbour).add(node);
            }
            visited[node] = false;
        }

        // now traversing on finishing time
        int sccCount = 0;
        while (!finishingOrder.isEmpty()) {
            int node = finishingOrder.pop();
            if (!visited[node]) {
                sccCount++;
                sccDfsPrint(revAdjList, visited, node);
                  System.out.println();

            }
          
        }
        System.out.println(" total scc " + sccCount);

    }

    public static void main(String[] args) {
        int vertices = 10;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 0 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 7 },
                { 7, 5 },
                { 7, 8 },
                { 8, 9 },
                { 7, 9 }
        };

        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildDirectedGraph(vertices, edges);
        printScc(adjList);
    }

}