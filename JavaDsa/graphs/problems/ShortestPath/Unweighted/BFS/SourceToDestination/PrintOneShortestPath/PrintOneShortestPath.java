package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.PrintOneShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class PrintOneShortestPath {
    // this can be done in two ways one stroing entire path other is storing parent
    // better approach is using parent , the path storing is implemented in weighted
    // folder
    static ArrayList<Integer> getShortestPath(ArrayList<ArrayList<Integer>> adjList, int source, int destinantion) {
        boolean[] visited=new boolean[adjList.size()];
        ArrayList<Integer> shortestParent=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        //marking as no parent
        for(int i=0;i<adjList.size();i++){
            shortestParent.add(-1);
        }

        shortestParent.set(source, source);
        visited[source]=true;
        q.offer(source);

        while(!q.isEmpty()){
            int curNode=q.poll();
            for(int neighbour:adjList.get(curNode)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    shortestParent.set(neighbour, curNode);
                    q.offer(neighbour);

                }
            }
        }
        //destination not found
        if(shortestParent.get(destinantion)==-1){
            return new ArrayList<>();
        }
        
        ArrayList<Integer> shortestPath = new ArrayList<>();

        int nodeInpath=destinantion;
        while(nodeInpath!=shortestParent.get(nodeInpath)){
            shortestPath.add(nodeInpath);
            nodeInpath=shortestParent.get(nodeInpath);
        }
        shortestPath.add(nodeInpath);
        //reverse
        Collections.reverse(shortestPath);
        return shortestPath;
    }

    public static void main(String[] args) {
        int nodes = 8;

        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 3 },
                { 3, 4 },
                { 3, 5 },
                { 4, 6 },
                { 5, 6 },
                { 6, 7 }
        };
        ArrayList<ArrayList<Integer>> adjList = GraphBuildUtil.buildUndirectedGraph(nodes, edges);
        System.out.println(getShortestPath(adjList, 0, 7));

    }

}
