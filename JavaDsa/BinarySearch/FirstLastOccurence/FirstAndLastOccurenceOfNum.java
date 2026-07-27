package FirstLastOccurence;

public class FirstAndLastOccurenceOfNum {
    static int[] firstAndLast(int[] arr,int elem){
        int[] ans=new int[2];
        ans[0]=getFirstOccurence(arr, elem);
        ans[1]=getLastOccurence(arr, elem);
        return ans;


    }
    private static int getFirstOccurence(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        int firstOccurence=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                firstOccurence=mid;
                end=mid-1;
            }
            else if(elem<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return firstOccurence;

    }
     private static int getLastOccurence(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        int lastOccurence=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                lastOccurence=mid;
                start=mid+1;
            }
            else if(elem<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return lastOccurence;

    }
    public static void main(String[] args) {
        int[] arr={1,2,2,2,3,3,3,4,5,6};
        int elem=3;
        int[] ans=firstAndLast(arr, elem);
        System.out.println("first in : "+ans[0]+" last in :"+ans[1]);
    }
    
}
