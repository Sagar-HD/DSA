package dynamicProgramming.lcs;

import java.util.Arrays;

public class LCS {
    //ill first write just to print lcs
    //using push recursion forward // construct answer from empty string until end of any string
    //just notice without dp how much time its taking 
    static String ans="";

    static void printlcs(String a,String b,String lcs){
        if(a.length()==0 || b.length()==0){
           if(lcs.length()>ans.length()){
            ans=lcs;

           }
           return;
        }
        if(a.charAt(0)==b.charAt(0)){
          
            printlcs(a.substring(1), b.substring(1), lcs+a.charAt(0));
        }
        else{
           
            printlcs(a.substring(1), b, lcs);
           
            printlcs(a, b.substring(1), lcs);
        }

    }

//memorisation with pull recursion backward 
//getting answer from smaller sub problem and deciding 
//i could have start comparing first chars and reduced string by 1 length by front also
//both are pull recursion but with forawrd direction

    static int lcsMemo(String a,String b,int[][] dp){

           if(a.length()==0 || b.length()==0){
           return 0;
              }
              if(dp[a.length()][b.length()]!=-1)  return dp[a.length()][b.length()];

        if(a.charAt(a.length()-1)==b.charAt(b.length()-1)){

       return dp[a.length()][b.length()]= 1+lcsMemo(a.substring(0,a.length()-1), b.substring(0,b.length()-1),dp);
        }
        else{
            return dp[a.length()][b.length()]= Math.max(lcsMemo(a.substring(0,a.length()-1), b,dp),lcsMemo(a, b.substring(0,b.length()-1),dp));
        }


    }
    //tabulation

    static int lcsTab(String a,String b){
        if(a.length()==0 || b.length()==0) return 0;

        int[][] dp=new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length();i++){
            dp[i][0]=0;
        }
        for(int j=0;j<b.length();j++){
            dp[0][j]=0;
        }
        //here i j represent length not index
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
                

            }
        }
        return dp[a.length()][b.length()];

    }
    //tabulation but larger index to smaller , smaller dependent to larger
    //this is bit unusual and inintuative it may look diffrent but its same pull
    //its same as before tabulation just processing string in reverse order 
    //important note this is not push model in push which we wrote first recursion to print lcs the smaller cells push its info to dependent cells
    //here just smaller index are dependent on larger index
      static int lcsTab2(String a,String b){
        if(a.length()==0 || b.length()==0) return 0;

        int[][] dp=new int[a.length()+1][b.length()+1];

        //filling 0 for all outside index as 0 
        //all b out of index is 0 
        for(int i=0;i<a.length();i++){
            dp[i][b.length()]=0;

        }
         for(int j=0;j<b.length();j++){
            dp[a.length()][j]=0;

        }
       
        //here i j represent index not length

        for(int i=a.length()-1;i>=0;i--){
            for(int j=b.length()-1;j>=0;j--){

                if(a.charAt(i)==b.charAt(j)){
                    dp[i][j]=1 + dp[i+1][j+1];
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                

            }
        }
        //we get answer in i=0 and j=0 bcs our dp means the state means longest sequence from here to end 
        //we need lcs considering whole string so 0 0 represents lcs from here to end of string
        return dp[0][0];

    }

    

    //this is just for concpet understanding mostly we use pull only 
    // here from known answer we expand the information 
    //its used in bfs , dijkstra and edge relaxation problems 
    //Known states push information to their dependent states.
    //just notice how we are pushing information foward to all posible choice we have to move forward
    //this is wt we do in consructive recursion problems

    static int lcsPushTab(String a, String b) {

    int n = a.length();
    int m = b.length();

    int[][] dp = new int[n + 1][m + 1];

    //as base case 0 is not intitalised by default its 0 

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {

            // Push current value forward
            dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j]);

            // Match 
            if (a.charAt(i) == b.charAt(j)) {
                dp[i + 1][j + 1] =
                    Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
            }
        }
    }

    return dp[n][m];
}
    
    public static void main(String[] args) {
        String a="ibcadfmdgkosd";
        String b="youknowwhatiamgod";

        // String a="abc";
        // String b="banbc";
        printlcs(a, b, "");
        System.out.println(ans);


        //memo 

        int[][] dp=new int[a.length()+1][b.length()+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(lcsMemo(a, b,dp));
        System.out.println(lcsTab(a, b));
        System.out.println(lcsTab2(a, b));

        
    }
    
}
