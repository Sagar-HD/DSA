package lcs.palindromicSubsequence;

public class LongestRepeatingSubSequence {
    
 
    static int getlongestRepeatingSubSequence(String a){
        if(a.length()==0) return 0;
        String b=new String(a);

        int[][] dp=new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1) && i!=j){
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                   dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[a.length()][a.length()];

    }
    public static void main(String[] args) {
        String a="abdabad";
        System.out.println(getlongestRepeatingSubSequence(a));
    }
    
}
