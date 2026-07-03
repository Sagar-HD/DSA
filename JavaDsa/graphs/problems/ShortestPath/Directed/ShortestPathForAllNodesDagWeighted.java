package graphs.problems.ShortestPath.Directed;

import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathForAllNodesDagWeighted {

    static class Pair {
        private int toNode;
        private int weight;

        public Pair(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }

    }

    static void getTopoDfs(ArrayList<ArrayList<Pair>> adjList, Stack<Integer> stack, boolean[] visited, int node) {
        visited[node] = true;
        for (Pair neighbourPair : adjList.get(node)) {
            if (!visited[neighbourPair.toNode]) {
                getTopoDfs(adjList, stack, visited, neighbourPair.toNode);
            }

        }
        stack.push(node);

    }

    static int[] getShortestDistances(ArrayList<ArrayList<Pair>> adjList, int source) {
        int[] shortestDistances = new int[adjList.size()];
        // setting every node as infinite distance
        for (int i = 0; i < shortestDistances.length; i++) {
            shortestDistances[i] = Integer.MAX_VALUE;
        }
        // first we need topological order
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.size()];
        for (int node = 0; node < adjList.size(); node++) {
            if (!visited[node]) {
                getTopoDfs(adjList, stack, visited, node);
            }
        }

        //set shortest distance of source from source is always 0

        shortestDistances[source]=0;
        // now as we got topological order
        // Process each vertex in topological order.
        // If the vertex is reachable from the source, relax all its outgoing edges
        // to update the shortest distances to its neighbors.

        while (!stack.isEmpty()) {
            int node=stack.pop();
        
            //if its reachable from source process its neighbour and updates with its shortest path 
            //if not reachable ignore , all reachable nodes come after source in topo order
            if(shortestDistances[node]!=Integer.MAX_VALUE){
                for(Pair neighbour :adjList.get(node)){
                    int newDistance=shortestDistances[node]+neighbour.weight;
                    shortestDistances[neighbour.toNode]=Math.min(shortestDistances[neighbour.toNode],newDistance);
                }
                
            }
        }

        return shortestDistances;

    }

    public static void main(String[] args) {
        int nodes = 7;
        // fromNode,toNode,Weight
        int[][] edges = {
                { 0, 5, 3 },
                { 0, 4, 2 },
                { 4, 5, 1 },
                { 4, 6, 3 },
                { 4, 2, 1 },
                { 6, 1, 2 },
                { 2, 3, 3 },
                { 1, 3, 1 }

        };

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int fromNode = edges[i][0];
            int toNode = edges[i][1];
            int weight = edges[i][2];
            adjList.get(fromNode).add(new Pair(toNode, weight));
        }
        int source = 6;
        int[] shortestDistances = getShortestDistances(adjList, source);
        for (int distance : shortestDistances) {
            if (distance == Integer.MAX_VALUE) {
                System.out.print(" Infinity not reachable ");
            } else {
                System.out.print(distance + " ");

            }
        }

    }

}
