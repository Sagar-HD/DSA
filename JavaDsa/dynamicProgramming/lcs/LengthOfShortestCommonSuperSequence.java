package dynamicProgramming.lcs;

/**
 * LengthOfShortestCommonSuperSequence
 */
public class LengthOfShortestCommonSuperSequence {
    static int shortestCommonSupersecquence(String a,String b){
        if(a.length()==0) return b.length();
        if(b.length()==0) return a.length();

        int[][] dp=new int[a.length()+1][b.length()+1];
        //base cases already 0
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);

                }
            }
        }
        int lcs=dp[a.length()][b.length()];
  
     
        int shortestCommonSuperSequence=a.length()+b.length()-lcs;

        return shortestCommonSuperSequence;

    }

    public static void main(String[] args) {
        String a="AGGTAB";
        String b="GXTXAYB";
        System.out.println(shortestCommonSupersecquence(a, b));
    }
}