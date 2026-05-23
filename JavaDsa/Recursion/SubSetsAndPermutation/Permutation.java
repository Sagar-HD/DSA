package SubSetsAndPermutation;

public class Permutation {
    static void perm(String processed,String unProcessed){
        if(unProcessed.length()==0){
            System.out.println(processed);
            return;
        }
        for(int i=0;i<=processed.length();i++){
            String start=processed.substring(0,i);
            String end=processed.substring(i,processed.length());
            String cur=start+unProcessed.charAt(0)+end;
            perm(cur, unProcessed.substring(1));


        }

    }
    //this method is also used in combination of k elements
    static void perm2(String str,int index,String ansSoFar,boolean[] visited){
        if(index==str.length()){
            System.out.println(ansSoFar);
            return;
        }
        for(int i=0;i<str.length();i++){
            if(visited[i]==false){
                visited[i]=true;
                perm2(str, index+1, ansSoFar+str.charAt(i), visited);
                visited[i]=false;
            }

        }


    }
    
    public static void main(String[] args) {
        String str="abc";
        perm("", str);
        boolean[] visited=new boolean[str.length()];
        System.out.println("//////");
        perm2(str,0,"", visited);
    }
}
