package RecursionOnArray;
public class BubbleSortUsing2Functions {

    static void bubble(int[] arr,int n){
        if(n==0){
            return;
        }
        sort(arr, n);
        bubble(arr, n-1);
    }
    static void sort(int[] arr,int n) {
        if(n==0){
          return;
        }
        
        if(arr[n]<arr[n-1]){
            int temp=arr[n];
            arr[n]=arr[n-1];
            arr[n-1]=temp;

        }
        sort(arr,n-1);
    }
    public static void main(String[] args) {
        int[] arr={1,9,2,1,3,62,6,35,68,43};
           bubble(arr, 9);
           for(int i:arr){
            System.out.println(i);
           }
    }
    
}
