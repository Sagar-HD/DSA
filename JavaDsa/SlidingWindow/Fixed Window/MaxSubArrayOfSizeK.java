
public class MaxSubArrayOfSizeK  {
    static int getMax(int[] arr,int k){
        int max=Integer.MIN_VALUE;
        if(k>arr.length) return -1;

        int start=0;
        int end=0;
        int sum=0;
        while(end<k){
            sum+=arr[end];
            end++;
        }
        max=sum;
        while(end<arr.length){
            sum+=arr[end];
            sum-=arr[start];
            end++;
            start++;
            if(sum>max){
                max=sum;
            }
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        int[] arr ={-1,3,1,-4,1,5};
        getMax(arr,2);
    }
}