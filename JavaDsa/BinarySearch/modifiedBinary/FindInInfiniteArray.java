package modifiedBinary;

public class FindInInfiniteArray {
    static int search(int[] arr,int elem){
        int start=0;
        int end=1;
        //we cant simulate infinite so just putting check for bounds
        while(end<arr.length && elem>arr[end]){
             start=end+1;
            end=end*2;
           
        }
        end = Math.min(end, arr.length - 1);
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                return mid;
            }
            else if(elem<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return index;


    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int elem=11;
        System.out.println(search(arr, elem));
    }
    
}
