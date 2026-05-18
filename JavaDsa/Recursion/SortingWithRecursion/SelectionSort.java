package SortingWithRecursion;

public class SelectionSort {
    static void sort(int[] arr,int pass,int index,int minIndex){
        if(pass==arr.length-1){
            return;
        }
        if(index<=arr.length-1){
            if(arr[index]<arr[minIndex]){
            minIndex=index;
            }
            sort(arr,pass,index+1,minIndex);
        }
        else{
            int temp=arr[minIndex];
            arr[minIndex]=arr[pass];
            arr[pass]=temp;
sort(arr,pass+1,pass+2,pass+1);
        }

    }
    public static void main(String[] args) {
           int[] arr={1,9,3,6,2,88,0,24,1};
        sort(arr,0,1,0);
        for(int i:arr){
            System.out.println(i);
        }
    }
    
}
