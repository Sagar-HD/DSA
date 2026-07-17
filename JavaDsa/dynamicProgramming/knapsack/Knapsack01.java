package dynamicProgramming.knapsack;

import java.util.Arrays;

public class Knapsack01{
    static int getMaxLootMemo( int[] values,int[] weights,int capacity,int n,int[][] dp){
        if(n==0 || capacity==0){
            return 0;
        }
        if(dp[n][capacity]!=-1){
            return dp[n][capacity];
        }
      
     if(weights[n-1]<=capacity){

            

        int take=getMaxLootMemo(values, weights, capacity-weights[n-1], n-1,dp)+values[n-1];
        int skip=getMaxLootMemo(values, weights, capacity, n-1,dp);
             
          //max of taking or skipping
          return dp[n][capacity]=Math.max(take,skip);

    }
    
        return dp[n][capacity]=getMaxLootMemo(values, weights, capacity, n-1,dp);
    
      

    }
    static int getSafeMaxRobTab(int[] values,int[] weights,int capacity){
        if(capacity==0 || weights.length==0){
            return 0;
        }
        int[][] dp=new int[values.length+1][capacity+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
      
       
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(weights[i-1]<=j){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }

            }
        }
        return dp[weights.length][capacity];
       

    }
    
   
    public static void main(String[] args) {
        int[] values={2,3,4,5,1};
        int[] weights={5,4,3,2,1};

        int capacity=4;
        int[][] dp=new int[values.length+1][capacity+1];
        for(int i=0;i<dp.length;i++){

            Arrays.fill(dp[i],-1);

        }

        System.out.println(getMaxLootMemo(values, weights, capacity, values.length,dp));
        System.out.println(getSafeMaxRobTab(values, weights, capacity));
    }


}