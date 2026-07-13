package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToDestination.PrintOneShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
//this is not so optimal solution
//we store the path in queue for all neighbours in queue we have another approach
//in bfs the first we reach the destination its the shortest , but in weighted dijkstra the first node visit cant gaurante 
//but priority queue gaurantees first removalof destination from q is its the  then its the shortest path 

// Non-negative edge weights guarantee that after removing the destination from
// the Priority Queue, no future path can produce a smaller distance.
// If a deeper path were actually cheaper, the Priority Queue would have processed bcs dijkstra is shortest digger (like gold digger)
//it is blind for shortest path even if destination is already in queue it selects the shortest distance path first
//by this we can gaurantee the first removal of destinantion is the shortest 
// if any other deeper node has shortest path then they would have reached the destination before now.

public class PrintShortestPath {
     static class QueuePair{
        int node;
        int weight;
        ArrayList<Integer> path;
        public QueuePair(int node, int weight, ArrayList<Integer> path) {
            this.node = node;
            this.weight=weight;
            this.path=path;
       
        }
        
    }
      static class Pair{
        int node;
        int weight;
        
        public Pair(int node, int weight) {
            this.node = node;
            this.weight=weight;
           
       
        }
        
    }

 static ArrayList<Integer> getShortestPath(ArrayList<ArrayList<Pair>> adjList,int source,int destinantion){
       ArrayList<Integer> shortestDistances=new ArrayList<>();
       //setting infity for all at first
       for(int i=0;i<adjList.size();i++){
        shortestDistances.add(Integer.MAX_VALUE);

       }
       //marking source distance as 0 bcs shortest  distances from source to itself is 0
       shortestDistances.set(source, 0);
       PriorityQueue<QueuePair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));
        ArrayList<Integer> startPath=new ArrayList<>();
        startPath.add(source);
       q.offer(new QueuePair(source, 0,startPath));
       while(!q.isEmpty()){
        QueuePair cur=q.poll();
        int curNode=cur.node;
        int distanceFromSourceToCurNode=cur.weight;
        ArrayList<Integer> curPath=cur.path;

          if(curNode==destinantion){
            
            return curPath;
          }

       
        if(distanceFromSourceToCurNode>shortestDistances.get(curNode))continue;// added this for optimization removes outdated node processing
          //this is to remove nodes which were in queue sitting idle while we were processing all shortest first edges of them got relaxed but these were unware inside queue
          //later at some point of time when their distance get the chance  we unnecerray to their neighbours anyways they dont give optimal , instead of filtering in neighbours we stop here only

        for(Pair neighbour : adjList.get(curNode)){
            int neighbourNode=neighbour.node;
            int distanceFromCurNodeToNeighbour=neighbour.weight;
            int distanceFromSourceToNeighbourInthisPath=distanceFromSourceToCurNode+distanceFromCurNodeToNeighbour;
            if(distanceFromSourceToNeighbourInthisPath<shortestDistances.get(neighbourNode)){
                shortestDistances.set(neighbourNode, distanceFromSourceToCurNode+distanceFromCurNodeToNeighbour);
                curPath.add(neighbourNode);//adding this neighbour to path
                q.offer(new QueuePair(neighbourNode, distanceFromSourceToNeighbourInthisPath,new ArrayList<>(curPath)));
                curPath.remove(curPath.size()-1);//removing from cur path after adding node to q , bcs cur path must same as before for next neighbours

            }

        }



       }
       
       return new ArrayList<>();
    }
    //this methods is better than previous one it doesnt store all path along it , just finds the shortest distance and its parent from where it reached
    //later by backpropogating fron destinantion we can reach source
    static ArrayList<Integer> getShortestPathUsingParent(ArrayList<ArrayList<Pair>> adjList,int source,int destinantion){
           ArrayList<Integer> shortestDistances=new ArrayList<>();
            //setting infity for all at first
       for(int i=0;i<adjList.size();i++){
        shortestDistances.add(Integer.MAX_VALUE);

       }
         ArrayList<Integer> parentArray=new ArrayList<>();
           //setting parent as -1 bcs we dont know yet
       for(int i=0;i<adjList.size();i++){
        parentArray.add(-1);

       }
        //marking source distance as 0 bcs shortest  distances from source to itself is 0
       shortestDistances.set(source, 0);
       //marking source parent as itself bcs from there only we start
       parentArray.set(source, source);
       //priority queue based on weight 
       PriorityQueue<Pair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.weight, pair2.weight));
       q.offer(new Pair(source,0));
       while(!q.isEmpty()){
        Pair cur=q.poll();
        int curNode=cur.node;
        int currentDistance=cur.weight;
          if(currentDistance>shortestDistances.get(curNode))continue;// added this for optimization removes outdated node processing
          //this is to remove nodes which were in queue sitting idle while we were processing all shortest first edges of them got relaxed but these were unware inside queue
          //later at some point of time when their distance get the chance  we unnecerray to their neighbours anyways they dont give optimal , instead of filtering in neighbours we stop here only

        for(Pair neighbour:adjList.get(curNode)){
            int neighbourNode=neighbour.node;
            int distanceFromCurToNeighbour=neighbour.weight;
            int totalDistance=currentDistance+distanceFromCurToNeighbour;
            if(totalDistance<shortestDistances.get(neighbourNode)){
                //relaxation
                shortestDistances.set(neighbourNode, totalDistance);
                //adding this to process so its neighbours get updated
                q.offer(new Pair(neighbourNode, totalDistance));
                //set parent of this to curNode
                parentArray.set(neighbourNode, curNode);
            }
        }
       }
       if(shortestDistances.get(destinantion) == Integer.MAX_VALUE)return new ArrayList<>();//if destination not found
    //after marking all shortest distance from source to all nodes 
    //we could have also stopped after finding destination 
    ArrayList<Integer> shortestpath=new ArrayList<>();
    int nodeInpath=destinantion;
    while(parentArray.get(nodeInpath)!=nodeInpath){
        shortestpath.add(nodeInpath);
        nodeInpath=parentArray.get(nodeInpath);
    }
    //addinf source node to path which break the while loop
    shortestpath.add(nodeInpath);
    Collections.reverse(shortestpath);
    return shortestpath;



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
         System.out.println(getShortestPath(adjList, 0,2));
         System.out.println(getShortestPathUsingParent(adjList, 0, 2));
        
    }
    
}
