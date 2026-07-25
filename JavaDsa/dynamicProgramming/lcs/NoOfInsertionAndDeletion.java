package dynamicProgramming.lcs;

public class NoOfInsertionAndDeletion {

    static void insertAndDelete(String a,String b){
        if(a.length()==0){
            System.out.println("insertion :"+b.length());
            return;
        }
         if(b.length()==0){
            System.out.println("deletion :"+a.length());
            return;
        }
        
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

        System.out.println("insertion : "+ (b.length()-lcs));
        System.out.println("deletion : "+ (a.length()-lcs));

    }

    public static void main(String[] args) {
        String a="Sagar";
        String b="Danger";
        insertAndDelete(a, b);
    }
    
}
