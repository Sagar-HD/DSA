package dynamicProgramming.unboundedKnapsack;

public class RodCuttingMaxProfit {
    static int getMaxProfit(int[] availableCuts,int[] profit, int length){
        if(availableCuts.length==0) return 0;
        if(length==0) return 0;
        int[][] dp=new int[availableCuts.length+1][length+1];
        for(int i=0;i<availableCuts.length;i++){
            dp[i][0]=0;
        }
         for(int j=0;j<length+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<availableCuts.length+1;i++){
            for(int j=1;j<length+1;j++){
                if(availableCuts[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],profit[i-1]+dp[i][j-availableCuts[i-1]]);

                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
  return dp[availableCuts.length][length];
    }
    public static void main(String[] args) {
        int length = 8;

        int[] availableCuts = { 1, 3, 4, 5 };

        int[] profit = { 2, 7, 9, 10 };
        System.out.println(getMaxProfit(availableCuts, profit, length));
    }

}
