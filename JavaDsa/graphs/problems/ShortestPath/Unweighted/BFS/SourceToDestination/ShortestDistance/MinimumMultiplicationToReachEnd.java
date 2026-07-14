package graphs.problems.ShortestPath.Unweighted.BFS.SourceToDestination.ShortestDistance;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    static class Pair{
        int node;
        int noOfMuls;
        public Pair(int node, int noOfMuls) {
            this.node = node;
            this.noOfMuls = noOfMuls;
        }
        
    }
    static int[] getNeighbours(int node,int[] neighbourMultiply){
        int[] neighbours=new int[neighbourMultiply.length];
        for(int i=0;i<neighbourMultiply.length;i++){
            neighbours[i]=(node*neighbourMultiply[i])%100000;
        }
        return neighbours;

    }
    static int getshortestNoofMultiplicationToReach(int start,int end,int[] neighbourMultiply){
        //boolean[] visited=new boolean[100000]; we can use boolean array also
        //but for readabilty and understanding iam using set
        HashSet<Integer> visited=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        visited.add(start);
        q.offer(new Pair(start, 0));
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int curNode=cur.node;
            int mulTillCur=cur.noOfMuls;
            if(curNode==end){
                return mulTillCur;
            }

            for(int neighbour:getNeighbours(curNode, neighbourMultiply)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    q.offer(new Pair(neighbour, mulTillCur+1));

                }
            }

            
        }


        return -1;

    }
    public static void main(String[] args) {
        int start=3;
        int end=75;
        int[] neighbourMultiply={2,5,7};
        System.out.println(getshortestNoofMultiplicationToReach(start, end, neighbourMultiply));

    }
    
}
