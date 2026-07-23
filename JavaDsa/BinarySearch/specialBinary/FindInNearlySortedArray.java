package specialBinary;

public class FindInNearlySortedArray {
    static int search(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                return mid;
            }
            if(mid-1>=start && arr[mid-1]==elem){
                return mid-1;
            }
            else if(mid+1<=end && arr[mid+1]==elem){
                return mid+1;
            }
            else if(elem<arr[mid]){
                end=mid-2;
            }
            else{
                start=mid+2;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={2,1,3,4,6,5};
        int elem=1;
        System.out.println(search(arr, elem));
    }
    
}
