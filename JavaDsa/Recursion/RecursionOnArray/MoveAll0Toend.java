package RecursionOnArray;

public class MoveAll0Toend {
    static void moveZeros(int[] arr,int start, int end){
        if(start>=end){
            return ;
        }
        if(arr[start]==0 && arr[end]!=0){
            int temp=arr[end];
            arr[end]=arr[start];
            arr[start]=temp;
            start++;
            end--;
        }
        if(arr[start]!=0){
            start++;
        }
        if(arr[end]==0){
            end--;
        }
        moveZeros(arr, start, end);



        
    }
    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,5,7};
        moveZeros(arr, 0, arr.length-1);
        for(int i :arr){
            System.out.print(i+" ");
        }

    }
    
}
