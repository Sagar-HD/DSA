package lcs;

public class PrintShortestCommonSuperSequence {
    static void printShortestCommonSupersequence(String a,String b){
        if(a.length()==0) 
        {
            System.out.println(b);
            return;
        }
         if(b.length()==0) 
        {
            System.out.println(a);
            return;
        }

        //dp of lcs 
        int[][] dp=new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
              dp[i][j]=1+dp[i-1][j-1];
                }
                else{
              dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        //backtracking from ans to find path to print scs
      int i=a.length();
      int j=b.length();
      StringBuilder ans=new StringBuilder();

      while(i>0 && j>0){

        if(a.charAt(i-1)==b.charAt(j-1)){
            ans.append(a.charAt(i-1));
            i--;
            j--;

        }
        else{

            if(dp[i-1][j] > dp[i][j-1]){

                ans.append(a.charAt(i-1));
                i--;
            }
            else{
                ans.append(b.charAt(j-1));
                j--;
            }

        }

      }
      while(j>0){
        ans.append(b.charAt(j-1));
        j--;
      }
      while(i>0){
        ans.append(a.charAt(i-1));
        i--;
      }
      System.out.println(ans.reverse());

    }

    public static void main(String[] args) {
        String a="abcdaf";
        String b="acbcf";
        printShortestCommonSupersequence(a, b);
    }
    
}
