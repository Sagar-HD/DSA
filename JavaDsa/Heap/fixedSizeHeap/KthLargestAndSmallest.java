import java.util.*;

public class KthLargestAndSmallest{
    public static void main(String[] args) {
      int[] arr={5,3,8,5,9};
      //3,5,5,8,9
      int k=2;
      
      //min heap
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      for(int i:arr){
        pq.add(i);
        if(pq.size()>k){
          pq.poll();
        
        }
        
      }
      System.out.println("k th largest :"+pq.peek());

      PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
        maxHeap.add(i);
        if(maxHeap.size()>k){
          maxHeap.poll();
        
        }
        
      }
      System.out.println("k th smallest :"+maxHeap.peek());




    }
}