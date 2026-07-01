/*
1791. Find Center of Star Graph
Solved
Easy
Topics
premium lock icon
Companies
Hint
There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

 
 */
class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
         int[] indegree=new int[n+1];//bcs its 1 based index 0 will be empty
        int center=-1;
        for(int relation=0;relation<edges.length;relation++){
          
            int node1=edges[relation][0];
            int node2=edges[relation][1];
            indegree[node1]++;
            indegree[node2]++;

        }
        for(int node=1;node<=n;node++){
            if(indegree[node]==n-1){
                center = node;
                break;
            }
        }
        return center;
        
    }
}