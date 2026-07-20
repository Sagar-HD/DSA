package dynamicProgramming.knapsack;

import java.util.ArrayList;
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

    static int getMinDifUsingSubSetSum(int[] arr,int sum){
        //we noticed that one side of sum is enough to calculate other side we can derive from subtracting it from total sum
        //so we compressed state from leftsum rightsum and index to index leftsum this much info is enough to define a state 


        /*now we know the left sum can range from 0 to total sum 
        but we want to minimize the dif so we know left sum be in  left half of the range 
        and many numbers in the range dont even form a subset in given array
        so by finding wt all numbers in range from a subset we can then find which sub set gives min difference later using them
        */

        //tabulation to find sub set sum exists of not 0 to total sum 
        boolean[][] dp1=new boolean[arr.length+1][sum+1];

        //when we have 0 elements we cant make a subset except when sum is required 0 so set false for ceels represeting 0 elements as false
        //when sum is 0 it will be overiden by next base case
        for(int j=0;j<sum+1;j++){
            dp1[0][j]=false;
        }

        //when required sum is 0 its always possible as set base case where j=0 as true 
        for(int i=0;i<arr.length+1;i++){
            dp1[i][0]=true;

        }
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp1[i][j]= dp1[i-1][j] || dp1[i-1][j-arr[i-1]];

                }
                else{
                    dp1[i][j]=dp1[i-1][j];
                }

            }
        }
        //now we filled dp for sub set sum 
        // now we check when we take all elements into considertaion means i=arr.length that are only the valid complete answers
        //we create a arraylist for which sum we can make a subset
        ArrayList<Integer> validSubsetSum=new ArrayList<>();
        for(int j=0;j<sum+1;j++){
            if(dp1[arr.length][j]){
                validSubsetSum.add(j);
            }
        }

        //now among this all valid sub set sum we find the min difference possible 
         int minDiff=Integer.MAX_VALUE;
        for(int subsetSum : validSubsetSum){
            int dif=Math.abs(subsetSum-(sum-subsetSum));
            minDiff=Math.min(minDiff, dif);

        }


        return minDiff;

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

        ///
        System.out.println("solution using  standard method ,finding min among all valid subset sum techniques");
        System.out.println(getMinDifUsingSubSetSum(arr, sum));
    }

}
