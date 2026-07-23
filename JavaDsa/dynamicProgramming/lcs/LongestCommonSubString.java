package dynamicProgramming.lcs;

public class LongestCommonSubString {

    // the state is longest substring till this index : not longest substring ending at this index
    // we are pushing count foward if streak breaks 0 else the current count so sub problem can extend if they can 
    //when we process everything we return ans 
    // this is constructive push forward recursion
    // we can memorise this dp using 3d dp

    static int getLongest(String a, String b, int count) {
        if (a.length() == 0 || b.length() == 0) {
            return count;
        }

        if (a.charAt(0) == b.charAt(0)) {
            return getLongest(a.substring(1), b.substring(1), count + 1);

        } else {
            return Math.max(
                    count,
                    Math.max(
                            getLongest(a.substring(1), b, 0),
                            getLongest(a, b.substring(1), 0)));
        }

    }

    // This recursion can be memoized as a 3D DP: dp[i][j][count].
    //
    // Here the state is:
    // (i, j) -> current positions
    // count -> current matching substring length
    //
    // We cannot directly make it a 2D DP with the same state because
    // (i, j) alone is not enough to represent the state.
    // Two calls can reach the same (i, j) with different values of count.
    //
    // To obtain a 2D DP, we redefine the state.
    //
    // Instead of:
    // dp[i][j] = longest substring seen till (i,j)
    //
    // We define:
    // dp[i][j] = longest substring ENDING at (i,j)
    //
    // Why?
    //
    // Suppose we only know the best substring till (i,j).
    // When the next characters match, we don't know whether that best substring
    // actually ended at (i,j), so we cannot decide whether to extend it.
    //
    // By storing "ending at (i,j)", we know that if
    // a[i] == b[j], the current substring MUST extend from
    // dp[i-1][j-1]; otherwise it restarts from 0.


    //be clear the state  means substring length till here
    static int longestSubStringTab(String a,String b){
        if(a.length()==0 || b.length()==0) return 0;
        int[][] dp=new int[a.length()+1][b.length()+1];
        //no need to intialise base as its default 0

        int max=Integer.MIN_VALUE;//bcs we need max substring from all possibilties

        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                int ansForCell=0;
                if(a.charAt(i-1)==b.charAt(j-1)){
                 
                    dp[i][j] = ansForCell = 1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=ansForCell=0;
                }
                max=Math.max(max, ansForCell);

            }
        }
        return max;
    }

    


    public static void main(String[] args) {
        String a = "absagamana";
        String b = "ababmsagapapa";

        System.out.println(getLongest(a, b, 0));
        System.out.println(longestSubStringTab(a, b));

    }

}
