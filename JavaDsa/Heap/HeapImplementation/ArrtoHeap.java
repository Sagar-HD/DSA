package HeapImplementation;
import java.util.*;

public class ArrtoHeap {
  static void heapify(int[] arr,int node){
    
      int n=arr.length;
      int left=(node*2)+1;
      int right=(node*2)+2;
      int smallest=node;
      
      if(node<0){
        return ;
      }
      
      if(left<n && arr[left]<arr[smallest])
      {  smallest=left;
      }
      if(right<n && arr[right]<arr[smallest])
       { smallest=right;
      }
      if(node!=smallest){
        int temp=arr[node];
        arr[node]=arr[smallest];
        arr[smallest]=temp;
        heapify(arr,smallest);
      }
    
  }
  static void convert(int[] arr){
    int n=arr.length;
    int node=(n/2)-1;
    while(node>=0){
      heapify(arr,node);
      node--;
    }
    }
      
    
  
    public static void main(String[] args) {
      int[] arr={3,6,2,8,3,9};
      convert(arr);
      for(int i:arr){
        System.out.println(i);
      }
    }
}