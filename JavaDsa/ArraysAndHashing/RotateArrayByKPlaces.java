import java.util.*;

public class RotateArray {
  public static void reverse(int[] arr,int start,int end)
    {
    while(start<end){
      int temp=arr[start];
      arr[start]=arr[end];
      arr[end]=temp;
      start++;
      end--;
    }
    
  }
  public static void leftRotate(int[] arr,int k){
    k=k%arr.length;
    
    reverse(arr,0,k-1);
    reverse(arr,k,arr.length-1);
    reverse(arr,0,arr.length-1);
    
    
    
  }
  public static void rightRotate(int[] arr,int k){
    k=k%arr.length;
    reverse(arr,0,arr.length-1);
    reverse(arr,0,k-1);
    reverse(arr,k,arr.length-1);
    
    
    
    
  }
    public static void main(String[] args) {
    int[] arr={1,2,3,4,5};
    leftRotate(arr,3);
    for(int i:arr){
      System.out.println(i);
    }
    rightRotate(arr,3);
    for(int i:arr){
      System.out.println(i);
    }
    }
}