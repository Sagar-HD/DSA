package minHeapMerge;
import java.util.*;

public class SortNearlySortedArray {
    public static void main(String[] args) {
      Integer[] arr={6,5,3,2,8,10,9};
      int k=3;
     PriorityQueue<Integer> minHeap=new PriorityQueue<>();
     for(int i=0;i<k+1;i++){
      minHeap.add(arr[i]);

     }
     int index=0;
     for(int i=k+1;i<arr.length;i++){
      arr[index]=minHeap.poll();
      index++;
      minHeap.add(arr[i]);

     }
     while(!minHeap.isEmpty()){
      arr[index]=minHeap.poll();
      index++;
     }

     for(int i:arr){
      System.out.println(i);
     }
      
    }
}