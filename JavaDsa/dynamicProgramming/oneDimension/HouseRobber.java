package dynamicProgramming.oneDimension;

import java.util.Arrays;

public class HouseRobber {

    static int getSafeMaxRobMemo(int[] arr, int n, int[] dp) {
        int max = 0;
        if (n <=0  ) {
            return max;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        max = Math.max(arr[n-1] + getSafeMaxRobMemo(arr, n - 2, dp), getSafeMaxRobMemo(arr, n-1, dp));
        dp[n] = max;
        return max;

    }

    static int getSafeMaxRobTab(int[] arr) {
        if (arr.length == 0)
            return 0;

        if (arr.length == 1)
            return arr[0];

        int[] dp = new int[arr.length+1];

        dp[0] = 0;
        dp[1] = arr[1];

        for (int i = 2; i <= arr.length; i++) {
            dp[i] = Math.max(dp[i-1], arr[i-1] + dp[i - 2]);
        }

        return dp[arr.length];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 7, 2, 3, 1, 9 };
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        System.out.println(getSafeMaxRobMemo(arr, arr.length, dp));
        System.out.println(getSafeMaxRobTab(arr));

    }

}
