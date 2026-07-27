package RotatedArray;
import java.util.*;

public class MinInRotatedArray {
  static int find(int[] arr){
    int start=0;
    int end=arr.length-1;
    while(start<end){
      int mid=start+(end-start)/2;
      if(arr[mid]<=arr[0]){
        end=mid;
      }
      else{
        start=mid+1;
      }
      
      
    }
    return arr[start];
  }
    public static void main(String[] args) {
      int[] arr={7,8,9,4,5,6};
      System.out.println(find(arr));
    }
}