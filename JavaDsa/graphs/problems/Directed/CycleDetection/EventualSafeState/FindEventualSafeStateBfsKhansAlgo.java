package graphs.problems.Directed.CycleDetection.EventualSafeState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class FindEventualSafeStateBfsKhansAlgo {
    // in this method first we find a nodes with 0 outdegree as they will be the
    // safe node for sure
    // now backpropogate from that safe nodes to find dependent safe node
    // then from that safe node change graph direction bcs we need to move backward
    // where there is cycle we dont get indegree as 0 so they dont get added
    private static ArrayList<Integer> giveSafeNodes(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> safeNodes = new ArrayList<>();

        // find safe node with outdegree 0
        // now queue to process nodes
        Queue<Integer> q = new LinkedList<>();
        // add that found safe node to q
        for (int node = 0; node < adjList.size(); node++) {

            if (adjList.get(node).size() == 0) {
                q.offer(node);

            }
        }

        // if safe node found reverse direction from it
        ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            revAdjList.add(new ArrayList<>());
        }
        // also create indegree while reversing graph
        // but its actually outdegree from original graph after reversing its indegree
        int[] indegree = new int[revAdjList.size()];
        for (int node = 0; node < adjList.size(); node++) {
            for (int neigbhour : adjList.get(node)) {
                revAdjList.get(neigbhour).add(node);
                indegree[node]++;
            }
        }

        while (!q.isEmpty()) {
            int curNode = q.poll();
            safeNodes.add(curNode);
            for (int neigbhour : revAdjList.get(curNode)) {
                indegree[neigbhour]--;
                // Original outdegree becomes 0.
                // This means every outgoing neighbour
                // has already been proven safe,
                // so this node is also safe.
                if (indegree[neigbhour] == 0) {
                    q.offer(neigbhour);

                }
            }

        }

        return safeNodes;
    }

    public static void main(String[] args) {
        int v = 12;
        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 6 },
                { 6, 7 },
                { 4, 5 },
                { 5, 6 },
                { 8, 1 },
                { 8, 9 },
                { 9, 10 },
                { 10, 8 },
                { 11, 9 }

        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildDirectedGraph(v, edges);
        ArrayList<Integer> safeNodes = giveSafeNodes(adjList);
        System.out.println(safeNodes);

    }

}
