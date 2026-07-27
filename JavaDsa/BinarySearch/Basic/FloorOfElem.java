package Basic;

public class FloorOfElem {
    static int getFloor(int[] arr,int elem){
        int start=0;
        int end=arr.length-1;
        int floor=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==elem){
                return arr[mid];
            }
            else if(elem<arr[mid]){
                end=mid-1;
            }
            else{
                floor=arr[mid];
                start=mid+1;
            }


        }
        return floor;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,6,7,8};
        int elem=5;
        int elem2=7;
        System.out.println(getFloor(arr, elem));
          System.out.println(getFloor(arr, elem2));

        
    }
    
}
