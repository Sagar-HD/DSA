package dynamicProgramming.knapsack;

import java.util.Arrays;

public class SubSetSumK {
    static boolean isExistsMem(int[] arr, int k, int n, Boolean[][] dp) {
        if (k == 0)
            return true;

        if (n < 0)
            return false;

        if (dp[n][k] != null)
            return dp[n][k];

        if (arr[n] <= k) {
            boolean take = isExistsMem(arr, k - arr[n], n - 1, dp);
            boolean skip = isExistsMem(arr, k, n - 1, dp);

            return dp[n][k] = take || skip;

        }
        return dp[n][k] = isExistsMem(arr, k, n - 1, dp);

    }

    static boolean isExistsTab(int[] arr, int k, int n) {
        if (k == 0)
            return true;

        if (n == 0)
            return false;

        Boolean[][] dp = new Boolean[arr.length + 1][k + 1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        for (int j = 1; j <= k; j++)
            dp[0][j] = false;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][k];

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 4 };
        int k = 6;
        Boolean[][] dp = new Boolean[arr.length][k + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], null);
        }
        System.out.println(isExistsMem(arr, k, arr.length - 1, dp));
        System.out.println(isExistsTab(arr, k, arr.length));
    }

}
