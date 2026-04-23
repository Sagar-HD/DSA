import java.util.*;

public class LastStoneWeight{
    public static void main(String[] args) {
      int[] arr={2,7,4,1,8,1};
      PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
      for(int i:arr){
        
        pq.add(i);
      }
      while(pq.size()>1){
        int num1=pq.poll();
        int num2=pq.poll();
        int num3=num1-num2;
        if(num3>0){
          pq.add(num3);
        }
      }
      System.out.println(pq.isEmpty() ? 0 : pq.poll());
    }
}