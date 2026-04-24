import java.util.*;

public class MergeSort {
  static void merge(int[] arr,int start,int mid,int end){
  int i=start;
  int j=mid+1;
  int k=0;
  int[] temp=new int[end-start+1];
  
    while(i<=mid && j<=end){
      if(arr[j]>arr[i]){
        temp[k]=arr[i];
        k++;
        i++;
      }
      else{
        temp[k]=arr[j];
        k++;
        j++;
      }
      
      
    }
    while(i<=mid){
      temp[k]=arr[i];
        k++;
        i++;
    }
    while(j<=end){
temp[k]=arr[j];
        k++;
        j++;
    }
    int l=start;
    for(int v=0;v<temp.length;v++){
      arr[l]=temp[v];
      l++;
    }
  }
  static void sort(int[] arr, int start,int end){
    if(start>=end){
      return;
      
    }
    int mid=(start+end)/2;
    
    sort(arr,start,mid);
    sort(arr,mid+1,end);
    merge(arr,start,mid,end);
  }
    public static void main(String[] args) {
      int[] arr={2,6,1,8,9,4};
      sort(arr,0,arr.length-1);
      for(int n:arr){
        System.out.println(n);
      }
    }
}