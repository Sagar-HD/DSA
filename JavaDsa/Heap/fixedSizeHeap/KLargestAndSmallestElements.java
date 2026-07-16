import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestAndSmallestElements {
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
      System.out.println("k largest elements are :");
      
      while(!pq.isEmpty()){
        System.out.println(pq.poll());
      }

      PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
        maxHeap.add(i);
        if(maxHeap.size()>k){
          maxHeap.poll();
        
        }
        
      }
      System.out.println("k smallest elements are :");
       while(!maxHeap.isEmpty()){
        System.out.println(maxHeap.poll());
      }




    }
    
}
