package lcs.palindromicSubsequence;

public class LongestPalindromicSubsequence {
    //we just need to find lcs among a string and it reverse to get lps
    //how this works 
    //if we reverse a string and find subsequence for this string then we are finding only which match from both front end back side
    //if a subsequence is plaindrome even if we reverse order will same right 
    //exploiting this to solve this problem 


    static int getLongestPalindromicSubsequence(String a){
        if(a.length()==0) return 0;

        String b = new StringBuilder(a).reverse().toString();

        int[][] dp=new int[a.length()+1][b.length()+1];

        //now 0 size is always 0 no need fill its by default 0 
     //i and j are represeting size not index
        
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){

                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{
                  dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }


            }
        }
        return dp[a.length()][b.length()];


    }
    public static void main(String[] args) {
        String a="bbbab";
        System.out.println(getLongestPalindromicSubsequence(a));
        
    }
    
}
