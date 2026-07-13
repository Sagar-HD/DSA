package graphs.TraversalTechniques;

import java.util.ArrayList;

import graphs.representation.GraphBuildUtil;

public class Dfs {

    static void getDfs(int vertices, ArrayList<ArrayList<Integer>> adjList, int node, boolean[] visited,
            ArrayList<Integer> dfs) {

        visited[node] = true;
        dfs.add(node);
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {

                getDfs(vertices, adjList, neighbour, visited, dfs);

            }
        }

    }

    // returning dfs
    static ArrayList<Integer> getDfsList(int vertices, ArrayList<ArrayList<Integer>> adjList, int node,
            boolean[] visited) {
        ArrayList<Integer> dfs = new ArrayList<>();
        visited[node] = true;
        dfs.add(node);
        for (int neighbour : adjList.get(node)) {
            if (!visited[neighbour]) {

                dfs.addAll(getDfsList(vertices, adjList, neighbour, visited));

            }
        }
        return dfs;

    }

    public static void main(String[] args) {

        int vertices = 4;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },

        };

        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(vertices, edges);
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> dfs = new ArrayList<>();
        getDfs(vertices, adjList, 0, visited, dfs);
        System.out.println(dfs);
    }

}
