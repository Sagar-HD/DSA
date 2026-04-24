import java.util.*;

public class RecursiveBubbleSort{
  static void sort(int[] arr,int n){
    if(n<2){
      return;
    }
    for(int i=0;i<n-1;i++){
      if(arr[i+1]>arr[i]){
        int temp=arr[i];
        arr[i]=arr[i+1];
        arr[i+1]=temp;
      }
    }
    sort(arr,n-1);
  }
    public static void main(String[] args) {
      int arr[]={2,6,1,9,4,3};
      sort(arr,arr.length);
      for(int i:arr){
        System.out.println(i);
      }
    }
}