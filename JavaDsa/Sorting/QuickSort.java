import java.util.*;

public class QuickSort {
  
  static int partition(int[] arr,int start,int end){
    int pivot=arr[start];
    int i=start+1;
    int j=end;
    while(i<=j){
      while(i<=end && arr[i]<=pivot){
        i++;
      }
      while(j>=start && arr[j]>pivot){
        j--;
      }
      if(i<j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
      }
      
    }
    
    arr[start]=arr[j];
    arr[j]=pivot;
    System.out.print("printing array after partition\n");
   for(int m=start;m<=end;m++){
     if(m==j){
       System.out.print(" \" "+arr[m]+" \" ");
     }else{
       System.out.print(arr[m]);
     }
   }
   System.out.println();
    return j;
  }
  
  static void sort(int[] arr,int start,int end){
    if(start>=end){
      return;
    }
    int num=partition(arr,start,end);
    sort(arr,start,num-1);
    sort(arr,num+1,end);
    
  }
  
    public static void main(String[] args) {
      int[] arr={1,5,2,8,7};
      sort(arr,0,arr.length-1);
      for(int n:arr){
        System.out.println(n);
      }
    }
}