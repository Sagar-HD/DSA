package RecursionOnArray;
import java.util.*;

public class ReverseArray{
 static void reverse(int[] arr,int start,int end){
    if(start>=end)return;
    
    int temp=arr[end];
    arr[end]=arr[start];
    arr[start]=temp;
    start++;
    end--;
    reverse(arr,start,end);
    
  }
    public static void main(String[] args) {
      int[] arr={1,4,5,6};
      reverse(arr,0,arr.length-1);
      for(int i:arr){
        System.out.print(i);
      }
    }
}