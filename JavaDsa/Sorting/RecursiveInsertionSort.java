import java.util.*;

public class RecursiveInsertionSort{
  static void sort(int[] arr,int n){
    if(n==arr.length){
      return;
    }
    int num=arr[n];
    int i;
    for( i=n-1;i>=0;i--){
      if(arr[i]<num){
        arr[i+1]=arr[i];
      }
      else{
        break;
      }
    }
    arr[i+1]=num;
    sort(arr,n+1);
  }
    public static void main(String[] args) {
      int arr[]={2,6,1,9,4,3};
      sort(arr,1);
      for(int i:arr){
        System.out.println(i);
      }
    }
}