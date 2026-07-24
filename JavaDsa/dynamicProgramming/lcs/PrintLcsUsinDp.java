package dynamicProgramming.lcs;

public class PrintLcsUsinDp {
    static void printLcs(String a,String b){
        if(a.length()==0 || b.length()==0)return;

        int[][] dp=new int[a.length()+1][b.length()+1];
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
        StringBuilder ans=new StringBuilder("");
        int i=a.length();
        int j=b.length();

        while(i>0 && j>0){

            if(a.charAt(i-1)==b.charAt(j-1)){
                 ans.append(b.charAt(j-1));
                 i--;
                 j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
           


        }
        System.out.println(ans.reverse());



    }
    public static void main(String[] args) {
          String a="ixawmygod";
        String b="youknowwhatiamgod";
        printLcs(a, b);
    }
    
}
