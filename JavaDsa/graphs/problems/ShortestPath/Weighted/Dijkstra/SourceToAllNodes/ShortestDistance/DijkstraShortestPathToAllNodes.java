package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToAllNodes.ShortestDistance;

import java.util.ArrayList;

import java.util.PriorityQueue;
//Dijkstra is neigther bfs nor bfs ordering 
//this is undircted graph example same for directed relaxes all neighbiur nodes 
//problem is explained in detail in readme

//this is explainantion in simple way how priority queue gaurantees shortest path 
//non negative edges plays a major role this thing break with negatives 

/*
 * Why can Dijkstra finalize a node when it is removed from the Priority Queue?
 *
 * In BFS:
 *      First discovery is shortest because BFS explores level by level.
 *
 * In Dijkstra:
 *      First valid removal from the Priority Queue is shortest because
 *      the Priority Queue always removes the smallest current distance.
 *
 * Question:
 *      What if another path goes much deeper in the graph and later
 *      comes back to this node with an even smaller distance?
 *
 * Answer:
 *      That cannot happen if all edge weights are NON-NEGATIVE.
 *
 *      Every unprocessed node already has distance >= currentDistance.
 *      Any path reaching this node through those unprocessed nodes must add
 *      another edge whose weight is >= 0.
 *
 *      So the new path can only become
 *
 *          >= currentDistance + 0
 *
 *      which can never be smaller than the current distance.
 *
 *      The only way a later path could become smaller is if an edge had
 *      a NEGATIVE weight, because then it could reduce the total distance
 *      after the node was already finalized.
 *
 *      That is exactly why Dijkstra requires all edge weights to be
 *      non-negative.
 */


public class DijkstraShortestPathToAllNodes {
   
      static class Pair{
        int node;
        int weight;
        
        public Pair(int node, int weight) {
            this.node = node;
            this.weight=weight;
           
       
        }
        
    }


    static ArrayList<Integer> getShortestDistances(ArrayList<ArrayList<Pair>> adjList,int source){
       ArrayList<Integer> shortestDistances=new ArrayList<>();
       //setting infity for all at first
       for(int i=0;i<adjList.size();i++){
        shortestDistances.add(Integer.MAX_VALUE);

       }
       //marking source distance as 0 bcs shortest  distances from source to itself is 0
       shortestDistances.set(source, 0);
       PriorityQueue<Pair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));

       q.offer(new Pair(source, 0));
       while(!q.isEmpty()){
        Pair cur=q.poll();
        int curNode=cur.node;
        int distanceFromSourceToCurNode=cur.weight;

        for(Pair neighbour : adjList.get(curNode)){
            int neighbourNode=neighbour.node;
            int distanceFromCurNodeToNeighbour=neighbour.weight;
            int distanceFromSourceToNeighbourInthisPath=distanceFromSourceToCurNode+distanceFromCurNodeToNeighbour;
            if(distanceFromSourceToNeighbourInthisPath<shortestDistances.get(neighbourNode)){
                shortestDistances.set(neighbourNode, distanceFromSourceToCurNode+distanceFromCurNodeToNeighbour);
                q.offer(new Pair(neighbourNode, distanceFromSourceToNeighbourInthisPath));

            }

        }



       }
       
       return shortestDistances;
    }
    public static void main(String[] args) {
        //undirected weighted graph
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        int nodes=6;//0,1,2,3,4,5
        for(int i=0;i<nodes;i++){
            adjList.add(new ArrayList<>());
        }
        int[][] edges={
            {0,1,1},
            {0,2,4},
            {0,3,2},
            {1,3,1},
            {3,2,1},
            {3,4,1},
            {4,5,3}
        };
        for(int i=0;i<edges.length;i++){
            int node1=edges[i][0];
            int node2=edges[i][1];
            int weight=edges[i][2];
            adjList.get(node1).add(new Pair(node2, weight));
               adjList.get(node2).add(new Pair(node1, weight));
              

        }
         System.out.println(getShortestDistances(adjList, 0));
        
    }
    
}
