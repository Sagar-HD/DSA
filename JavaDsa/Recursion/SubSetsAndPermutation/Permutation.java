package SubSetsAndPermutation;

import java.util.HashSet;

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
    //in this method no backtracking at each level iam using set to add a element only once in that position
       static void perm3(String input,String ansSoFar){
        if(input.isEmpty()){
            System.out.println(ansSoFar);
            return;
        }
        //new hash at each level to store the chars used at this position
        // a level is a position , for that position we are iterating over input and adding all possibilities
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<input.length();i++){
                 //just removing added element from input
                  char currentAlpha=input.charAt(i);
                  String newInput=input.substring(0,i)+input.substring(i+1);
                 if(!set.contains(currentAlpha)){
                    
                perm3(newInput,ansSoFar+currentAlpha);

                 }
             
            }

        }


    
    
    public static void main(String[] args) {
        String str="abc";
        perm("", str);
        boolean[] visited=new boolean[str.length()];
        System.out.println("//////");
        perm2(str,0,"", visited);
         System.out.println("//////");
        perm3(str,"");
    }
}
