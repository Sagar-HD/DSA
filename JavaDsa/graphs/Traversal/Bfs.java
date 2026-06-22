package graphs.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class Bfs {


static ArrayList<Integer> getBfs(int vertices,ArrayList<ArrayList<Integer>> adjList){
    ArrayList<Integer> bfs=new ArrayList<>();
    Queue<Integer> q=new LinkedList<>();
    boolean[] visited=new boolean[vertices+1];
//its 0 based index so adding 0 
//if starting point is given add that
    q.offer(0);
    visited[0]=true;
    while(!q.isEmpty()){
        int node=q.poll();
        bfs.add(node);
        for(int neighbour : adjList.get(node)){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                q.offer(neighbour);

            }
        }

    }



    return bfs;

}


    public static void main(String[] args) {
        int vertices=4;
        int[][] edges={
            {0,1},
            {1,2},
            {2,3},

        };

        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(vertices,edges);
         ArrayList<Integer> bfs=getBfs(vertices, adjList);
         System.out.println(bfs);

        
    }
    
}
