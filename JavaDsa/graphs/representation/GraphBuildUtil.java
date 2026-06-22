package graphs.representation;

import java.util.ArrayList;

public class GraphBuildUtil {

    // Undirected Graph
    public static ArrayList<ArrayList<Integer>> buildUndirectedGraph(
            int vertices,
            int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }

    // Directed Graph
    public static ArrayList<ArrayList<Integer>> buildDirectedGraph(
            int vertices,
            int[][] edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {

            int from = edge[0];
            int to = edge[1];

            adj.get(from).add(to);
        }

        return adj;
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {

        for (int i = 0; i < adj.size(); i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
    }
}