package PrefixSum;

public class PivotIndex {
    //prefex and sufix sum must have sum all all elements before or after including that element
    //but in this question we are not adding current element as per requirement 
    static int getPivot(int[] arr){
        int index=-1;
        int[] preSum=new int[arr.length];
        int[] sufSum=new int[arr.length];
        int sum=0;
        for(int i=0;i<preSum.length;i++){
            preSum[i]=sum;
            sum+=arr[i];
        }
        sum=0;
        for(int i=sufSum.length-1;i>=0;i--){
            sufSum[i]=sum;
            sum+=arr[i];
        }
        for(int i=0;i<arr.length;i++){
            if(preSum[i]==sufSum[i]){
                index=i;
                return i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr={1,7,3,6,5,6};
        System.out.println(getPivot(arr));
        
    }
    
}
