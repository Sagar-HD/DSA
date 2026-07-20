package dynamicProgramming.knapsack;

/**
 * NoOfSubsetsWithGivenDifference
 */
public class NoOfSubsetsWithGivenDifference {
    static int getCount(int[] arr,int dif){
        int totalSum=0;
        for(int i:arr){
            totalSum+=i;
        }

        //sum1-sum1=dif
        //sum1+sum2=totalSum
        //sum1=dif+totalSum/2

          // Impossible if dif is greather than sum
    if (Math.abs(dif) > totalSum){
        return 0;
    }

        int neededSum=(dif+totalSum)/2;

        //but if dif+totalSum is odd then we need decimal sum so it cant exist

      if ((dif + totalSum) % 2 != 0) {
            return 0;
        }

        // now find no of subsets with neededSum
        int[][] dp=new int[arr.length+1][neededSum+1];

        for(int j=0;j<neededSum+1;j++){
            //we no elemns we cant make sum
            dp[0][j]=0;
            //but when we need 0 sum it will we overriden in net base condition
        }


        for(int i=0;i<arr.length+1;i++){
            //when we need 0 sum always we can make empty sub set we have 1 way
            dp[i][0]=1;

        }
        for(int i=1;i<arr.length+1;i++){
            for(int j=1;j<neededSum+1;j++){
                if(arr[i-1]<=j){
                dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        


        return dp[arr.length][neededSum];
    }

    public static void main(String[] args) {
        int[] arr={1,1,2,3};
        int dif=1;
        System.out.println(getCount(arr, dif));

    }
    
}