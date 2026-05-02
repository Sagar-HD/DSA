import java.util.*;

public class SortKSortedArray {
    public static void main(String[] args) {
      Integer[] arr={6,5,3,2,8,10,9};
      int k=3;
      PriorityQueue<Integer> heap=new PriorityQueue<>();
      int start=0;
      int end=0;
      while(end<arr.length){
        heap.offer(arr[end]);
        if(heap.size()<=k){
        end++;
        }
        else{
          Integer elem=heap.poll();
          arr[start]=elem;
          start++;
          end++;
        }
        
      }
      while(!heap.isEmpty()){
        arr[start]=heap.poll();
        start++;
        
      }
      for(Integer i:arr){
        System.out.println(i);
      }
      
    }
}