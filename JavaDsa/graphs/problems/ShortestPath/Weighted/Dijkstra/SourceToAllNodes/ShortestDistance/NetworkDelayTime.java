package graphs.problems.ShortestPath.Weighted.Dijkstra.SourceToAllNodes.ShortestDistance;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * NetworkTimeDelay
 */
public class NetworkDelayTime {
    public static class Pair{

        int node;
        int time;
        public Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    } 
    public static int helper(ArrayList<ArrayList<Pair>> adjList,int source,int n){
    int[] shortDistances=new int[n+1];
    for(int i=0;i<shortDistances.length;i++){
        shortDistances[i]=Integer.MAX_VALUE;
    }
    shortDistances[source]=0;
    PriorityQueue<Pair> q=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.time,pair2.time));
    q.offer(new Pair(source,0));
    while(!q.isEmpty()){
        Pair curPair=q.poll();
        int curNode=curPair.node;;
        int timeToCur=curPair.time;

        if(timeToCur>shortDistances[curNode]) continue;

        for(Pair neighbour:adjList.get(curNode)){
            int neighbourNode=neighbour.node;
            int neighbourTime=neighbour.time;
            int totalTime=timeToCur+neighbourTime;
            if(totalTime<shortDistances[neighbourNode]){
                shortDistances[neighbourNode]=totalTime;
                q.offer(new Pair(neighbourNode,totalTime));
            }

        }


    }
    int minTime=0;
    for(int node=1;node<adjList.size();node++){
        if(shortDistances[node]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            minTime=Math.max(minTime,shortDistances[node]);
        }

    }
return minTime;


}
    public static void main(String[] args) {
        int[][]times={{2,1,1},
        {2,3,1},
        {3,4,1}
    };
        int n=4;
        int k=2;
        ArrayList<ArrayList<Pair>> adjList=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int fromNode=times[i][0];
             int toNode=times[i][1];
             int time=times[i][2];
             adjList.get(fromNode).add(new Pair(toNode,time));
        }
        System.out.println(helper(adjList,k,n));
        
    }

    
}

