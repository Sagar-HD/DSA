package PrefixSum;

public class PrefixSumRange {
    static int rangeSum(int i,int j,int[] presum){
        if(j==0){
            return presum[0];
        }
        return presum[j]-presum[i];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6};
        int[] presum=new int[arr.length];
        presum[0]=arr[0];
        for(int i =1;i<arr.length;i++){
           
            presum[i]=presum[i-1]+arr[i];
        }
System.out.println(rangeSum(2, 4, presum));
System.out.println(rangeSum(3, 5, presum));
System.out.println(rangeSum(0, 4, presum));
    }
    
}
