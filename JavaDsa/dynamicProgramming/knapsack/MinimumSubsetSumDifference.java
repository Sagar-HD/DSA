package dynamicProgramming.knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    static int getMinDif3d(int[] arr, int leftSum, int rightSum, int index,int[][][] dp) {
        if (index == arr.length) {
            return Math.abs(leftSum - rightSum);
        }
        if(dp[index][leftSum][rightSum]!=-1){
            return dp[index][leftSum][rightSum];
        }

        int addToLeft = getMinDif3d(arr, leftSum + arr[index], rightSum, index + 1,dp);
        int addToRight = getMinDif3d(arr, leftSum, rightSum + arr[index], index + 1,dp);

        return dp[index][leftSum][rightSum]=Math.min(addToLeft, addToRight);

    }
    static int getMinDif2d(int arr[],int leftSum,int index,int[][] dp,int totalSum){
          if (index == arr.length) {
            return Math.abs(leftSum - (totalSum - leftSum));
        }
        if(dp[index][leftSum]!=-1){
            return dp[index][leftSum];
        }
        int take = getMinDif2d(arr, leftSum + arr[index],index + 1,dp,totalSum);
        int notTake = getMinDif2d(arr, leftSum, index + 1,dp,totalSum);

        return dp[index][leftSum]=Math.min(take, notTake);





    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 3, 4 };
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int[][][] dp = new int[arr.length][sum + 1][sum + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(getMinDif3d(arr, 0, 0, 0,dp));

        // compressed the state which can be derived

        int[][] dp2=new int[arr.length][sum+1];
        for(int i=0;i<dp2.length;i++){
            Arrays.fill(dp2[i], -1);
        }
        System.out.println(getMinDif2d(arr, 0, 0, dp2, sum));
    }

}
