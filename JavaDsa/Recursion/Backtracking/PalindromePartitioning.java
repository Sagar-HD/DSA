package Backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {
    static void printPartition(String input,ArrayList<String> ans){
        //base condition
        if(input.isEmpty()){
            System.out.println(ans);
            return;
        }
        //variable choices at a level
        for(int i=0;i<input.length();i++){
            //controlling recursion or contolled decision
            if(isPali(input.substring(0,i+1))){
                ans.add(input.substring(0,i+1));
                printPartition(input.substring(i+1), ans);
                //back tracking
                ans.remove(ans.size()-1);
            }

        }
    }
    static boolean isPali(String s){
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str="aab";
        printPartition(str, new ArrayList<>());
    }
}
