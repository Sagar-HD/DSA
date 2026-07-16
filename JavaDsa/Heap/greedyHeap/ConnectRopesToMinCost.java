package greedyHeap;
import java.util.PriorityQueue;

public class ConnectRopesToMinCost {
    static int getMinCost(int[] arr){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i:arr){
            minHeap.add(i);
        }
        int minCost=0;
        while(minHeap.size()>=2){
            int rope1=minHeap.poll();
            int rop2=minHeap.poll();
            int cost=rope1+rop2;
            minHeap.add(cost);
            minCost+=cost;

        }
       
        return minCost;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(getMinCost(arr));
    }
    
}
