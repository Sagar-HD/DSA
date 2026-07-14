package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToAllNodes.CountShortestPaths;

import java.util.ArrayList;
import java.util.PriorityQueue;
//observe how we can not just calculate no of ways to destinantion by counting when a node reaches them usinf 
/*    if(!visited[neighbour]){
              visit..
        }
       else{
            if(distance==distance[neighbour]){
                ways=ways+1;
            }
       }

       the above thing we cant do bcs we cant simple do ways+1 bcs its parent may have n ways to reach
       so we see ways to parent and add them
*/
import java.util.Queue;

public class CountShortestPaths {
        static class Pair{
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
        
    }
    static int[] getNoOfShortestPathToEveryNode( ArrayList<ArrayList<Pair>> adjList,int source){
          int[] shortestDistances=new int[adjList.size()];
        for(int i=0;i<adjList.size();i++){
            shortestDistances[i]=Integer.MAX_VALUE;
        }
        int[] shortestWays=new int[adjList.size()];
        PriorityQueue<Pair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));
        shortestDistances[source]=0;
        shortestWays[source]=1;
        q.offer(new Pair(source, 0));
        while(!q.isEmpty()){
            Pair cuPair=q.poll();
            int curNode=cuPair.node;
            int distanceTillCur=cuPair.weight;
            if(distanceTillCur>shortestDistances[curNode]) continue;

            for(Pair neighbour : adjList.get(curNode)){
                int neighbourNode=neighbour.node;
                int neighbourDistance=neighbour.weight;
                int totalDistance=distanceTillCur+neighbourDistance;
                if(totalDistance<shortestDistances[neighbourNode]){
                    shortestDistances[neighbourNode]=totalDistance;
                  q.offer(new Pair(neighbourNode, totalDistance));
                  shortestWays[neighbourNode]=shortestWays[curNode];


                }
                else if(totalDistance==shortestDistances[neighbourNode]){
                    shortestWays[neighbourNode]=shortestWays[neighbourNode]+shortestWays[curNode];

                }


            }



        }

        return shortestWays;


    }
    public static void main(String[] args) {
        int n=5;
        int[][] edges={
            {0,1,1},
            {0,2,1},
            {0,3,2},
            {2,3,1},
            {1,4,2},
            {3,4,1}

        };
         ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());

        }
        for(int i=0;i<edges.length;i++){
            int node1=edges[i][0];
             int node2=edges[i][1];
              int weight=edges[i][2];
              adjList.get(node1).add(new Pair(node2, weight));
              adjList.get(node2).add(new Pair(node1, weight));
        }
        int source=0;
        int[] shortestWays=getNoOfShortestPathToEveryNode(adjList, source);
        for(int i: shortestWays){
            System.out.println(i);
        }
    }
    
}
