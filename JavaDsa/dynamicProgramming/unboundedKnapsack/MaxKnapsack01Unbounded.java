package dynamicProgramming.unboundedKnapsack;

public class MaxKnapsack01Unbounded {
    static int getMax(int[] values,int[] weights,int capacity){
      
        int[][] dp=new int[values.length+1][capacity+1];
        for(int i=0;i<values.length+1;i++){
            dp[i][0]=0;
        }
          for(int j=0;j<capacity+1;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<values.length+1;i++){
            for(int j=1;j<capacity+1;j++){
                if(weights[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j], values[i-1]+dp[i][j-weights[i-1]]);

                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

  return dp[values.length][capacity];

    }

    public static void main(String[] args) {
          int[] values={2,3,4,5,1};
        int[] weights={5,4,3,2,1};

        int capacity=4;
        System.out.println(getMax(values, weights, capacity));
    }
    
}
