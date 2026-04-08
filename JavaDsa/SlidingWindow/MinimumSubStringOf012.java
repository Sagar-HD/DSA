import java.util.*;

public class MinimumSubStringOf012{
    static boolean check(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=0){
                return false;
            }
        }
        return true;
    }
    static int minimumSubString012(int[] arr){
        int start=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        int[] freq=new int[3];
        while(end<arr.length && !check(freq)){
            freq[arr[end]]++;
            end++;

        }
        while(end<arr.length){
            int value;

            while(check(freq)){
                value=end-start;
                if(value<min){
                    min=value;
                }
                freq[arr[start]]--;
                start++;
            }



            freq[arr[end]]++;
            end++;


        }
        while (check(freq)) {
            int value = end - start;
            min = Math.min(min, value);

            freq[arr[start]]--;
            start++;
        }
        System.out.println(min);
        return min;

    }
    public static void main(String[] args) {
        int[] arr ={0,1,1,1,2,1};
        minimumSubString012(arr);
    }
}