 package knapsack.unboundedKnapsack;

class CoinChangeNoOfWays {
    static int noOfways(int[] arr,int sum){
        if(sum==0){
            return 1;
        }
        if(arr.length==0){
            return 0;
        }
        int[][] dp=new int[arr.length+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<arr.length+1;i++){
            for(int j=0;j<sum+1;j++){

                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];

                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }

        }
        return dp[arr.length][sum];
        

    }
    public static void main(String[] args) {
        
        int[] arr={1,2,3};
        int sum=5;
        System.out.println(noOfways(arr, sum));
    }

    
}