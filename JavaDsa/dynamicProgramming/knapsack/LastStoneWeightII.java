package dynamicProgramming.knapsack;

public class LastStoneWeightII {

    public static int get(int[] stones){
        int totalSum=0;
        for(int i:stones){
            totalSum+=i;
        }
        //now range is 0 to sum but to minimize 0 to  sum/2
        //(a+b+c)(-c-d-e)=(a+b+c)-(c+d+e) divding into 2 sub sets and dif should be minimized
        //sum1-sum2 to be minimized sum1+sum2=total sum2=total-sum1 therefore sum1-(total-sum1) -> 2sum1-total must be minimised
        //now finding all posible sum1 and minimizing it 

        int range=totalSum/2;
        boolean[][] dp=new boolean[stones.length+1][range+1];

        for(int i=0;i<stones.length+1;i++)dp[i][0]=true;

        for(int i=1;i<stones.length+1;i++){
            for(int j=1;j<range+1;j++){
                if(stones[i-1]<=j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-stones[i-1]];

                }
                else{
                  dp[i][j]=dp[i-1][j];
                }
            }
        }
        //now finding all valid sum by taking whole array into consideration
        int minLastStone=Integer.MAX_VALUE;

         for(int j=0;j<range+1;j++){
            if(dp[stones.length][j]){
                int dif=Math.abs((2*j)-totalSum);
                minLastStone=Math.min(minLastStone,dif);
            }

         }




       return minLastStone;


    }
    public static void main(String[] args) {
        int[] stones={31,26,33,21,40};
        System.out.println(get(stones));
        
    }
    
}

