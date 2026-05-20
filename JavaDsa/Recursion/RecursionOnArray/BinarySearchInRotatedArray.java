package RecursionOnArray;
public class BinarySearchInRotatedArray {
static int serach(int[] arr,int target,int start,int end){
    if(start>end){
        return -1;
    }
    int mid=start+(end-start)/2;
    if(arr[mid]==target){
        return mid;
    }
    else if(arr[mid]>=arr[start]){
        if(target>=arr[start]&&target<arr[mid]){
            return serach(arr, target, start, mid-1);
        }
        else{
            return serach(arr, target, mid+1, end);
        }
    }
    else{
       if(target>arr[mid]&&target<=arr[end]){
        return serach(arr, target, mid+1, end);
        }
        else{
        return serach(arr, target, start, mid-1) ;
        }
    }



}


public static void main(String[] args) {
int[] arr={4,5,6,7,1,2,3};
int target=2;
System.out.println(serach(arr, target, 0, arr.length-1));

    
}
    
}