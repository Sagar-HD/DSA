package RecursionOnArray;
class CheckSorted{

    static boolean isSorted(int[] arr){

        return helper(arr, 0);
    }
    static boolean helper(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        
            return arr[index]<=arr[index+1] && helper(arr, index+1);
        
       
    }

    public static void main(String[] args){
      int[] arr={3,5,7,8,10,22,23};
    System.out.print(isSorted(arr));
    }
}