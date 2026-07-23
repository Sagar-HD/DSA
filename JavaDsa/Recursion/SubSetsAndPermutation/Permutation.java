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
        //permutation using swap method 
            static void perm4(String input,int index){

        if(index==input.length()){
            System.out.println(input);
            return;
        }
        //new hash at each level to store the chars swapped at this position
        // a level is a position , for that position we are iterating over input and adding all possibilities
        //only move forward from this index bcs swaoing without elements before is already handled
        HashSet<Character> set=new HashSet<>();
        for(int i=index;i<input.length();i++){
                
                //duplicates handled , controlled recursion
                 if(!set.contains(input.charAt(i))){
                    set.add(input.charAt(i));
                    String swappedString=swap(input, index, i);
                  perm4(swappedString,index+1);
                  //no need of backtracking in java Strings are immutable so everytime we mutate new string created so new string is passed everytime

                 }
             
            }

        }
static String swap(String str,int index1,int index2){
    if(index1==index2) return str;
    char char1=str.charAt(index1);
    char char2=str.charAt(index2);
    return str.substring(0,index1)+char2+str.substring(index1+1,index2)+char1+str.substring(index2+1);
}

    
    
    public static void main(String[] args) {
        String str="abc";
        perm("", str);
        boolean[] visited=new boolean[str.length()];
        System.out.println("//////");
        perm2(str,0,"", visited);
         System.out.println("//////");
        perm3(str,"");
        System.out.println("permutation by swapping");
        perm4(str, 0);
    }
}

/*
 * Why do all four methods generate permutations?
 *
 * All four solve the same underlying problem. The only difference is
 * how they represent the recursion state.
 *
 * 1. Insertion Method
 *    State = Processed String + Unprocessed String
 *
 * 2. Visited Array Method
 *    State = Current Permutation + visited[]
 *
 * 3. Remove From Input Method
 *    State = Current Permutation + Remaining Input
 *
 * 4. Swap Method
 *    State = Current Arrangement + Fixed Index
 *
 * Although the state representation is different in each approach,
 * the recursive choice is exactly the same:
 *
 *     "Choose the next character to place in the permutation."
 *
 * Each method explores every valid choice exactly once, so all of
 * them generate every possible permutation.
 */