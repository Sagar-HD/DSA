package dynamicProgramming.knapsack;


public class CountSubSetSumEqualToK {
    static int getCount(int[] arr, int k){
        if(k==0){
            return 1;
        }
        if(arr.length==0){
            return 0;
        }
         int[][] dp = new int[arr.length+1][k + 1];

        
        
         for(int j=0;j<dp[0].length;j++){
             dp[0][j]=0;
         }
          for(int i=0;i<dp.length;i++){
            dp[i][0]=1;
          }
          for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){

                if(arr[i-1]<=j){
                   dp[i][j]=dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
          }
    return dp[arr.length][k];
    }
       public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 4,3 };
        int k = 6;
        System.out.println(getCount(arr, k));
       
       
    }
    
}
