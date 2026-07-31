package lcs.palindromicSubsequence;
//min insertion is also same as min deletion
public class MinDeletionToMakePalindrome {
    //just find longest palindromic subsequence and total length - that is min no of deletion needed

    static int minDeletion(String a){
        if(a.length()==0) return  0;
        String b=new StringBuilder(a).reverse().toString();
        int[][]dp=new int[a.length()+1][b.length()+1];
        
        //base cases defualt 0 

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
        int longestPalindromicSubsequence=dp[a.length()][b.length()];
        // min no of deletion is length - lps
        return a.length()-longestPalindromicSubsequence;
    }
    public static void main(String[] args) {
        String a="chapapa"; //apapahc

        System.out.println(minDeletion(a));
    }
    
}
