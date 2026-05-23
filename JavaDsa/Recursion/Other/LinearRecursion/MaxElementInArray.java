package Other.LinearRecursion;

public class MaxElementInArray {
    static int max(int[] arr,int index){
        if(index==arr.length-1){
            return arr[index];
        }
        return Math.max(arr[index], max(arr, index+1));

    }
        static int max2(int[] arr,int index,int max){
        if(index==arr.length){
            return max;
        }
        if(arr[index]>max){
            max=arr[index];
        }
        return max2(arr,index+1,max);


    }
    public static void main(String[] args) {
        int[] arr={1,22,54,32,11};
        System.out.println(max(arr,0));
        System.out.println(max2(arr,0,Integer.MIN_VALUE));

    }
}
