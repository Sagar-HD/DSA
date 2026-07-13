package graphs.problems.Traversal.GeneralTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import graphs.representation.GraphBuildUtil;

public class CountProvincesInGraph {
    static int countProvinces( ArrayList<ArrayList<Integer>> adjList,int vertices){
        boolean[] visited=new boolean[vertices];
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<vertices;i++){

        if(visited[i]==false){
         count++;
        q.offer(i);
        visited[i]=true;
        
    
        while(!q.isEmpty()){

            int node=q.poll();

            for(int neighbour:adjList.get(node)){
                if(visited[neighbour]==false){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
            


        }
    }
    }
      return count;
    }

    public static void main(String[] args) {
        int vertices=7;
        int[][]edges={
            {0,1},
            {1,2},
            {2,3},
            {4,5},
           

        };
        ArrayList<ArrayList<Integer>> adjList=GraphBuildUtil.buildUndirectedGraph(vertices, edges);
        System.out.println(countProvinces(adjList, vertices));
    }
    
}