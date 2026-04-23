import java.util.*;

public class KthLargest{
    public static void main(String[] args) {
      int[] arr={5,3,8,5,9};
      int k=3;
      PriorityQueue<Integer> pq=new PriorityQueue<>();
      for(int i:arr){
        pq.add(i);
        if(pq.size()>k){
          pq.poll();
        
        }
        
      }
      System.out.println(pq.peek());
    }
}