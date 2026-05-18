package SortingWithRecursion;
public class BubbleSortUsing1fun {
    static void sort(int[] arr,int pass,int index ){
if(pass==0){
    return;
}
    if(index<pass){
    if(arr[index]>arr[index+1]){
        int temp=arr[index];
        arr[index]=arr[index+1];
        arr[index+1]=temp;
    }
    sort(arr,pass,index+1);
    }
    else{
sort(arr,pass-1,0);
    }
    }
    public static void main(String[] args) {
        int[] arr={1,9,3,6,2,88,45,63};
        sort(arr,arr.length-1,0);
        for(int i:arr){
            System.out.println(i);
        }

    }
    
}
