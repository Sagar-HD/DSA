package FirstLastOccurence;

public class CountElementsInSortedArray {
    static int getCount(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        int count=0;
        //another approach can be usinf first and last occurence index and subtract them and find length
        //in worst case this can go to O(n)
        //so always use first and last ocurence index to find length which is always O(log n)
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                count++;
                int ptr=mid-1;
                while(ptr>=start && arr[ptr]==elem){
                    count++;
                    ptr--;
                }
                ptr=mid+1;
                while(ptr<=end && arr[ptr]==elem){
                    count++;
                    ptr++;
                }
                return count;
            }
            else if(elem<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return count;

    }
    public static void main(String[] args) {
         int[] arr={1,2,2,2,3,3,3,4,5,6};
        int elem=3;
        System.out.println(getCount(arr, elem));
    }
    
}
