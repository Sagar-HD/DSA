import java.util.*;

public class FirstNegativeInWindow{
    public static void main(String[] args) {
      int[] arr={1,2,3,-1,2,-6,-7,6,-9};
      int k=4;
      int i=0;
      int j=0;
      Queue<Integer> queue=new LinkedList<>();
      
      while(j<arr.length){
        if(arr[j]<0){
          queue.offer(j);
          
        }
        
      
        if(j-i+1<k){
          j++;
        }
        else{
          
          
if(queue.isEmpty()){
    System.out.println(0);
} else {
    System.out.println(arr[queue.peek()]);
}
          
          i++;
          j++;
          if (!queue.isEmpty() && queue.peek() < i) {
    queue.poll();
}
        }
        
        
      }
        
      
    }
}