import java.util.*;

public class SearchInRotatedArray {
  static int find(int[] arr,int n){
    int start=0;
    int end=arr.length-1;
    while(start<=end){
      int mid=start+(end-start)/2;
      if(arr[mid]==n){
        return mid;
      }
      else if(arr[mid]<arr[start]){
        if(n>arr[mid] && n<=arr[end]){
          start=mid+1;
          
        }
        else{
          end=mid-1;
        }
        
      }
      else{
        if(n<arr[mid] && n>=arr[start]){
          end=mid-1;
          
        }
        else{
          start=mid+1;
        }
        
      }
      
      
    }
    return -1;
  }
    public static void main(String[] args) {
      int[] arr={7,8,9,4,5,6};
      System.out.println(find(arr,5));
    }
}