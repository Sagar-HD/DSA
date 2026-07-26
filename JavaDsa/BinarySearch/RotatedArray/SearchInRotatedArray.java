package RotatedArray;


public class SearchInRotatedArray {
  //another approach is to find min of array using binary serach and split array into 2 sorted array and run 2 binary search
  static int find(int[] arr,int n){
    int start=0;
    int end=arr.length-1;
    while(start<=end){
      int mid=start+(end-start)/2;
      if(arr[mid]==n){
        return mid;
      }
          // most important case for duplicates if both start mid and end are equal we cant decide which side to go so we shrink both side
          //this shrink goes on until we can decide it only skips duplicate which is not our answer
    if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
        start++;
        end--;
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