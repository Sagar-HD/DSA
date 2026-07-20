package dynamicProgramming.knapsack;

public class CountTargetSumByAssiningSign {
    static int getCount(int[] arr, int sum) {

        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        if (Math.abs(sum) > totalSum) {
            return 0;
        }
        // here was we are partioining elemnts into two sub set one of positive and one
        // of negative
        // +a +b -c -d = sum given (a+b)-(c+d) =sum given from remvinng negative sign
        // out of negtive subset it subset sum difference
        // noe lets sum1 - sum2 =sum sum1+sum2=totalSum --> sum1=totalSum+given sum/2
        // we just need to find no of sum1 possible
        // we just convert question to find noOfSubset equal to k

        if ((totalSum + sum) % 2 != 0) {
            return 0;
            // bcs we dont have fractional num in array
        }
        int neededSum = (totalSum + sum) / 2;

        int[][] dp = new int[arr.length + 1][neededSum + 1];
        //only intitialising sum =0 and empty subset case as 1 way bcs there may be 0 in array and number of ways to get 0 sum may change
         dp[0][0]=1;
      //j should start from 0 bcs it should consider when array has 0 as elements the 0 sum must be increased
        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 0; j < neededSum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][neededSum];

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int sum = 2;
        System.out.println(getCount(arr, sum));

    }

}
