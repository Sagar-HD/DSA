package dynamicProgramming.knapsack;

public class EqualSumPartition {
    static boolean isPartitionPossibleMemo(int[] arr,int sum,int n,Boolean[][] dp){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null) return dp[n][sum];

        if(arr[n-1]<=sum){
            return dp[n][sum]=isPartitionPossibleMemo(arr, sum, n-1,dp)||isPartitionPossibleMemo(arr, sum-arr[n-1], n-1,dp);

        }
        else{
       return dp[n][sum]=isPartitionPossibleMemo(arr, sum, n-1,dp);
        }

    }
    static boolean isPartitionPossibleTab(int[] arr){
        int sum=0;
         for(int i=0;i<arr.length;i++){
            sum+=arr[i];

        }
        if(sum%2!=0){
            return false;
        }

        Boolean[][] dp=new Boolean[arr.length+1][(sum/2)+1];
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=false;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
      for(int i=1;i<dp.length;i++){
        for(int j=1;j<dp[0].length;j++){
            if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];

            }
            else{
                dp[i][j]=dp[i-1][j];
            }
        }
      }

 return dp[arr.length][sum/2];

    }
    public static void main(String[] args) {
        int[] arr={1, 2, 5};
        int sum=0;
         for(int i=0;i<arr.length;i++){
            sum+=arr[i];

        }
        Boolean[][] dp=new Boolean[arr.length+1][(sum/2)+1];
        
       
        if(sum%2==0){
            sum/=2;
        System.out.println(isPartitionPossibleMemo(arr, sum, arr.length,dp));
        }
        else{
            System.out.println(false);
        }


        ///tabulation
        
        System.out.println(isPartitionPossibleTab(arr));

    }
    
}
