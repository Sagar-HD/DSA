package fixedSizeHeap;

import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * KClosestPointToOrigin
 */
public class KClosestPointToOrigin {

     public static int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair<Integer,Integer>> maxHeap=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair2.getValue(),pair1.getValue()));
        for(int i=0;i<points.length;i++){
           maxHeap.add(new Pair<>(i,(points[i][0]*points[i][0])+(points[i][1]*points[i][1])));
           if(maxHeap.size()>k){
            maxHeap.poll();
           }
        }
        int[][] ans=new int[k][2];
        int index=0;
        while(!maxHeap.isEmpty()){

            Pair<Integer,Integer> pr=maxHeap.poll();
            int pointIndex=pr.getKey();
            ans[index][0]=points[pointIndex][0];
            ans[index][1]=points[pointIndex][1];
            index++;


        }
        return ans;
        
    }

    public static void main(String[] args) {
       int[][]points= {
        {1,3},
        {-2,2}};
        int k=1;
        int[][] ans=kClosest(points, k);
        for(int i=0;i<ans.length;i++){
            System.out.println("x :"+ans[i][0] + " y :"+ans[i][1]);
        }
        
    }
}