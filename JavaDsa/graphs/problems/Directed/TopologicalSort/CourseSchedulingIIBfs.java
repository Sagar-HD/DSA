package graphs.problems.Directed.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedulingIIBfs {
     public ArrayList<Integer> getTopo(ArrayList<ArrayList<Integer>> adjList) {
        int[] indegree = new int[adjList.size()];
        ArrayList<Integer> topoSort = new ArrayList<>();
        for (int node = 0; node < adjList.size(); node++) {
            for (int neighbour : adjList.get(node)) {
                indegree[neighbour]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < adjList.size(); node++) {
            if (indegree[node] == 0) {
                q.offer(node);

            }
        }
        while (!q.isEmpty()) {
            Integer curNode = q.poll();
            topoSort.add(curNode);
            for (int neighbour : adjList.get(curNode)) {

                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.offer(neighbour);

                }

            }

        }
        return topoSort.size() == adjList.size() ? topoSort : new ArrayList<>();

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int row = 0; row < prerequisites.length; row++) {
            Integer fromEdge = prerequisites[row][1];
            Integer toEdge =prerequisites[row][0];
            adjList.get(fromEdge).add(toEdge);

        }
        ArrayList<Integer> topoSort = getTopo(adjList);
      
        int[] arr = new int[topoSort.size()];

        for (int i = 0; i < topoSort.size(); i++) {
            arr[i] = topoSort.get(i);
        }
        return arr;
        

    }
    public static void main(String[] args) {
        // khans algorithm used CycleDetcetion + topoSort
        
    }
    
}
