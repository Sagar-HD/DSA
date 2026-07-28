package modifiedBinary;

public class PeakInBiotonicArrayMountain {
    static int PeakElement(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
            }
            else{
                end=mid;
                
            }

        }
        return arr[start];

    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,3,2,1};
        System.out.println(PeakElement(arr));
    }
    
}
