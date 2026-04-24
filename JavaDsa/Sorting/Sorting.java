import java.util.*;

public class Sorting{
  static void bubbleSort(int[] arr){
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr.length-i-1;j++){
        if(arr[j]>arr[j+1]){
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
        }
      }
    }
    
  }
  static void selectionSort(int[] arr){
    for(int i=0;i<arr.length;i++){
      int min=Integer.MAX_VALUE;
      int index=i;
      for(int j=i;j<arr.length;j++){
        if(arr[j]<min){
          min=arr[j];
          index=j;
        }
        
      }
      int temp=arr[index];
      arr[index]=arr[i];
      arr[i]=temp;
    }
    
  }
  static void insertionSort(int[] arr){
    for(int i=1;i<arr.length;i++){
      int num=arr[i];
      int j;
      for( j=i-1;j>=0;j--){
        if(num>=arr[j]){
          
          break;
        }
       
       arr[j+1]=arr[j];
       
        
          
        }
      arr[j+1]=num;
        
      }
      
    }
    
  
  
    public static void main(String[] args) {
      int[] arr={2,1,9,4,5};
      selectionSort(arr);
      for(int num:arr){
        System.out.println(num);
      }
    }
}