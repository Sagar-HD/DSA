package SubSetsAndPermutation;

import java.util.ArrayList;

public class LetterCaseChangeNumberSamePermutation {
    static ArrayList<String> numberSameLetterChangePerm(String input,String output){
        ArrayList<String> ans=new ArrayList<>();
        if(input.isEmpty()){
            ArrayList<String> sub=new ArrayList<>();
            sub.add(output);
           
            return sub;
        }
        if(Character.isAlphabetic(input.charAt(0))){
            ans.addAll(numberSameLetterChangePerm(input.substring(1), output+input.toLowerCase().charAt(0)));
           ans.addAll(numberSameLetterChangePerm(input.substring(1), output+input.toUpperCase().charAt(0)));

        }
        else if(Character.isDigit(input.charAt(0))){
            ans.addAll(numberSameLetterChangePerm(input.substring(1), output+input.charAt(0)));

        }else{
            System.out.println("invalid input");
            return new ArrayList<>();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str="ab1B2c3";
        ArrayList<String> ans=numberSameLetterChangePerm(str, "");
        System.out.println(ans);
    }
    
}
