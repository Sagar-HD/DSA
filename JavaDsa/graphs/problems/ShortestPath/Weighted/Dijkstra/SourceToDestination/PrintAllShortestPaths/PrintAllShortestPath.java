package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToDestination.PrintAllShortestPaths;

import java.util.ArrayList;
import java.util.Collections;

import java.util.PriorityQueue;

public class PrintAllShortestPath {
    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;

        }

    }

    static ArrayList<ArrayList<Integer>> getAllShortestPaths(ArrayList<ArrayList<Pair>> adjList, int source,
            int destination) {
        ArrayList<Integer> shortestDistances = new ArrayList<>();
        // setting infity for all at first
        for (int i = 0; i < adjList.size(); i++) {
            shortestDistances.add(Integer.MAX_VALUE);

        }
        ArrayList<ArrayList<Integer>> parents = new ArrayList<>();

        for (int i = 0; i < adjList.size(); i++) {
            parents.add(new ArrayList<>());
        }

        // marking source distance as 0 bcs shortest distances from source to itself is
        // 0
        shortestDistances.set(source, 0);

        // priority queue based on weight
        PriorityQueue<Pair> q = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.weight, pair2.weight));
        q.offer(new Pair(source, 0));
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int curNode = cur.node;
            int currentDistance = cur.weight;
            if (currentDistance > shortestDistances.get(curNode))
                continue;// added this for optimization removes outdated node processing
            // this is to remove nodes which were in queue sitting idle while we were
            // processing all shortest first edges of them got relaxed but these were unware
            // inside queue
            // later at some point of time when their distance get the chance we unnecerray
            // to their neighbours anyways they dont give optimal , instead of filtering in
            // neighbours we stop here only

            for (Pair neighbour : adjList.get(curNode)) {
                int neighbourNode = neighbour.node;
                int distanceFromCurToNeighbour = neighbour.weight;
                int totalDistance = currentDistance + distanceFromCurToNeighbour;
                if (totalDistance < shortestDistances.get(neighbourNode)) {
                    // relaxation
                    shortestDistances.set(neighbourNode, totalDistance);
                    // adding this to process so its neighbours get updated
                    q.offer(new Pair(neighbourNode, totalDistance));
                    // clearing parents if existed any
                    parents.get(neighbourNode).clear();
                    // adding this new shortest path parent to list
                    parents.get(neighbourNode).add(curNode);

                } else if (totalDistance == shortestDistances.get(neighbourNode)) {
                  
                        parents.get(neighbourNode).add(curNode);
                    
                }
            }
        }
        if (shortestDistances.get(destination) == Integer.MAX_VALUE)
            return new ArrayList<>();// if destination not found
        // after marking all shortest distance from source to all nodes
        // we could have also stopped after finding destination

        // creating arraylist to store all shortest paths
        ArrayList<ArrayList<Integer>> shortestpaths = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        buildPaths(destination, source, parents, currentPath, shortestpaths);

        return shortestpaths;
    }

    // dfs and backtracking method to build paths
    private static void buildPaths(
            int node,
            int source,
            ArrayList<ArrayList<Integer>> parents,
            ArrayList<Integer> currentPath,
            ArrayList<ArrayList<Integer>> shortestPaths) {

        currentPath.add(node);

        if (node == source) {

            ArrayList<Integer> path = new ArrayList<>(currentPath);
            Collections.reverse(path);
            shortestPaths.add(path);

        } else {

            for (int parent : parents.get(node)) {
                buildPaths(parent, source, parents, currentPath, shortestPaths);
            }

        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {

        // undirected weighted graph
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        int nodes = 6;// 0,1,2,3,4,5
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        int[][] edges = {
                { 0, 1, 1 },
                { 0, 2, 4 },
                { 0, 3, 2 },
                { 1, 3, 1 },
                { 3, 2, 1 },
                { 3, 4, 1 },
                { 4, 5, 3 }
        };
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int weight = edges[i][2];
            adjList.get(node1).add(new Pair(node2, weight));
            adjList.get(node2).add(new Pair(node1, weight));

        }
        ArrayList<ArrayList<Integer>> shortestPaths = getAllShortestPaths(adjList, 0, 2);
        for (ArrayList<Integer> path : shortestPaths) {
            System.out.println(path);
        }
    }

}
