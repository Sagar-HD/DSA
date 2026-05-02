import java.util.*;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        int sum=arr[0];

        int total=arr[0];

        for(int i:arr){
            total=Math.max(i,total+i);

            sum=Math.max(total,sum);

        }
        System.out.println(sum);
    }

}