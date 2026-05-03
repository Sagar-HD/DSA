import java.util.*;

public class Sort012 {
    public static void main(String[] args) {
      int[] arr={2,0,2,1,1,0};
      int start=0;
      int mid=0;
      int end=arr.length-1;
      while(mid<=end){
        
        if(arr[mid]==0){
          int temp=arr[start];
          arr[start]=arr[mid];
          arr[mid]=temp;
          mid++;
          start++;
        }
        else if(arr[mid]==2){
      int temp=arr[end];
          arr[end]=arr[mid];
          arr[mid]=temp;
          end--;
        }
        else{
          mid++;
        }
        
        
        
        
      }
      for(int i:arr){
        System.out.println(i);
      }
    }
    
}