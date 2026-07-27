package Basic;

public class OrderAgonisticSearch {

    static int search(int elem,int[] arr){
        if(arr.length==0)return-1;
        if(arr.length==1){
            return arr[0]==elem?0:-1;
        }
        //local class just to bind some method into grp using only inside this method
        final class BinarySearch{
            private int serachInAscending(int elem,int[] arr){
                System.out.println("asscending search");
                int start=0;
                int end=arr.length-1;
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
            return -1;
            }
             private int serachInDescending(int elem,int[] arr){
                 System.out.println("descending search");
             int start=0;
                int end=arr.length-1;
                while(start<=end){
                    int mid=start+(end-start)/2;
                    if(arr[mid]==elem){
                        return mid;
                    }
                    else if(elem<arr[mid]){
                       start=mid+1;
                    
                    }
                    else{
                     end=mid-1;
                    }


                }
            return -1;
            }


        }
        BinarySearch binarySearch=new BinarySearch();
        boolean isAscending=arr[0]<=arr[arr.length-1];

       return isAscending==true?binarySearch.serachInAscending(elem, arr):binarySearch.serachInDescending(elem, arr);
         
        

    }
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6};
        int[] arr2={6,5,4,3,2,1};
        int elem=4;
        System.out.println(search(elem, arr1));
        System.out.println(search(elem, arr2));
    }
    
}
