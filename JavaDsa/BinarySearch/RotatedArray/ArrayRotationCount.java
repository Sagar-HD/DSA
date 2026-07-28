package RotatedArray;

public class ArrayRotationCount {
    static int getRotationCount(int[] arr){
        //the min index is rotation count

        //sorted array no rotation if we didnt check our assumptions and logic fails
        if(arr[0]<=arr[arr.length-1]) return 0;

        int start=0;
        int end=arr.length-1;

        //in our logic we are not trying to find min elem directly
        //instead we are compressing serach space by checking is elem is in left sorted or right sorted
        //when start==end we get min elemnt in start or end index

        while(start<end){
            int mid=start+(end-start)/2;
           
            if(arr[mid]<arr[end]){
                 //if this true then we are in right sorted part
                end=mid;
                //bcs mid may be min element and less than this may be min but not greater

            }
            else{
                //we are in left sorted part we should move towards right sorted 
                start=mid+1;;
                //as we are in left sorted part min is always the smallest of right sorted part
            }

        }
        return start;

    }
 public static void main(String[] args) {
    int[] arr={4,5,6,7,1,2,3};
    System.out.println(getRotationCount(arr));
 }
    
}
