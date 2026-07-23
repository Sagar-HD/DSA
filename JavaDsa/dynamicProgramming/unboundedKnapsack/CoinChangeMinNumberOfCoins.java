package dynamicProgramming.unboundedKnapsack;

public class CoinChangeMinNumberOfCoins {
    static int minNoOfCoins(int[] arr, int sum) {
        if (sum == 0) {
            return 0;
        }
        if (arr.length == 0) {
            return 0;
        }

        int[][] dp = new int[arr.length + 1][sum + 1];
        // when no coins we have the anwer is not possible so we can represnt it with
        // any max value so it will be ignored
        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        // when sum needed is 0 always 0 coins
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = 0;

        }
        // we can also fill 2nd row representing only 1 coin and for all sums
        // if sum%coin value ==0 then noOfcoins needed is sum/coin value else not
        // possible to form mark as int max
        // but our recurence relation can do on its own depending on previous answer for
        // same coin and diffrent sum means in same row previous cells
        // usually when we have any one coin thats mathematically known base answer and
        // we compute based on it so some people fill it
        // but sum =0 is also a valid base and no coins having is also valid base which
        // makes answer impossible and mark as int max // we can reply on these two
        //below is code to fill 2 nd row
        // for (int j = 1; j <= sum; j++) {

        //     if (j % arr[0] == 0)
        //         dp[1][j] = j / arr[0];
        //     else
        //         dp[1][j] = Integer.MAX_VALUE - 1;

        // }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {

                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - arr[i - 1]]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }

        }
        return dp[arr.length][sum];

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int sum = 5;
        System.out.println(minNoOfCoins(arr, sum));
    }

}

// recursion + memo solution
class Solution {
    public int helper(int[] coins, int amount, int n, int[][] dp) {
        if (amount == 0) {
            return 0;
        }
        if (n == 0) {
            return -1;
        }

        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < amount + 1; j++) {
            dp[0][j] = 100000;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {

                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        int ans = helper(coins, amount, coins.length, dp);
        return ans == 100000 ? -1 : ans;

    }
}