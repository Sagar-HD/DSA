package lcs;

/**
 * PatternSequenceMatching
 */
public class PatternSequenceMatching {

    static boolean isMatch(String a,String b){
        if(a.length()==0) return true;
        //first ill find lcs between them

        int[][]dp=new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){

                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

                }
            }
        }
        int lcs=dp[a.length()][b.length()];
        return lcs==a.length();
    }
    public static void main(String[] args) {
        String a="sagar";
        String b="sbangtvar";
        System.out.println(isMatch(a, b));
    }

    
}