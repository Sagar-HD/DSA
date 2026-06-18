package KadanesAlgorithm;

public class MaxSumofSubArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,-4,6,-11,-6,2,3,4};
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            //this condition makes diffrence between kadanes and prefix sum
            sum=Math.max(sum+arr[i],arr[i]);

            max=Math.max(max,sum);
            


        }
        System.out.println(max);
    }
    
}
