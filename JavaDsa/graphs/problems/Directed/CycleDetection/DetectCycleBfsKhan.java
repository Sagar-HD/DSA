package graphs.problems.Directed.CycleDetection;

import java.util.ArrayList;
import java.util.LinkedList;

import java.util.Queue;

import graphs.representation.GraphBuildUtil;

//this is same as topological sort using bfs khans algorithm
//in dfs topologial it was ignoring cycle
//but in bfs topological sort if there was cycle we will not get a node with indegree 0 at some point of traversal
//so by comparing topo sort length with node length we can detect cycle , if no cycle both are equal else not equal
public class DetectCycleBfsKhan {
    static boolean checkCycle(ArrayList<ArrayList<Integer>> adjList) {
        int numberOfnodes = adjList.size();
        int countOfTopologicalSortNode = getTopologicOrderCount(adjList);

        return numberOfnodes!=countOfTopologicalSortNode;

    }

    static int getTopologicOrderCount(ArrayList<ArrayList<Integer>> adjList) {

        int[] indegree = new int[adjList.size()];
        for (int node = 0; node < adjList.size(); node++) {
            for (int outEdge : adjList.get(node)) {
                indegree[outEdge]++;
            }
        }
        int countOfNodes = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int node = 0; node < adjList.size(); node++) {
            if (indegree[node] == 0) {
                q.offer(node);

            }
        }
        while (!q.isEmpty()) {
            Integer node = q.poll();
            countOfNodes++;
            for (int outEdge : adjList.get(node)) {
                indegree[outEdge]--;
            }
            for (int neighbour : adjList.get(node)) {
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
            // we could have done this both removing indergree and adding node with 0
            // indegree in same loop
            // added 2 loops for redabilty
        }
        return countOfNodes;
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
                { 11, 9 },
                {10,8}//this is cycle

        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildDirectedGraph(v, edges);
        boolean hasCycle = checkCycle(adjList);
        System.out.println(hasCycle);

    }

}