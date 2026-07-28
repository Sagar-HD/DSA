package modifiedBinary;

public class SearchInBiotonicArray {
    static int search(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        int peakIndex=-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
     int ans1=ascendingSearch(arr,elem,0,start-1);
     int ans2=descendingSearch(arr, elem, start, arr.length-1);
     if(ans1!=-1) return ans1;
     if(ans2!=-1) return ans2;


   return -1;
    }
    static private int ascendingSearch(int[] arr,int elem,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                return mid;
            }
            else if(elem < arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
   return -1;
    }
     static private int descendingSearch(int[] arr,int elem,int start,int end){
         while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                return mid;
            }
            else if(elem < arr[mid]){
                start=mid+1;
            }
            else{
               end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
         int[] arr={1,3,4,6,5,2};
         int elem=3;
         System.out.println(search(arr, elem));
    }
    
}
