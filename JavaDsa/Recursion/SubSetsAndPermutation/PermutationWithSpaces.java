package SubSetsAndPermutation;

import java.util.ArrayList;

public class PermutationWithSpaces {
    static ArrayList<String> permuteSpace(String input,String output){
        ArrayList<String> ans=new ArrayList<>();
if(input.isEmpty()){
    ArrayList<String> base=new ArrayList<>();
    base.add(output);
    return base;
}

      ans.addAll(permuteSpace(input.substring(1), output+" "+input.charAt(0)));
      ans.addAll(permuteSpace(input.substring(1), output+input.charAt(0)));
      return ans;
    }


    //Another method where we dont cut first char
    //instead we handle it in recursive function only
    // to this we need the index info in state 
    // to make this decision
static ArrayList<String> permuteSpace2(String input,int index,String output){
     ArrayList<String> ans=new ArrayList<>();
    if(index==input.length()){
       ArrayList<String> base=new ArrayList<>();
      base.add(output);
      return base;
    }
    // you may add condition like this also 
    // else like i did below
    // if(index==0){
    //     ans.addAll(permuteSpace2(input,index+1, output+input.charAt(index)));
    //     return ans;

    // }
   if(index!=0){
      ans.addAll(permuteSpace2(input,index+1, output+" "+input.charAt(index)));
   }
      ans.addAll(permuteSpace2(input,index+1, output+input.charAt(index)));
      return ans;
    }
    public static void main(String[] args) {
        String input="abc";
        String output="";
         ArrayList<String> ans=permuteSpace2(input,0, output);
        System.out.println(ans);

        // at first char we no need to make decision so adding to output now only
        output=output+input.charAt(0);
        input=input.substring(1);
        ArrayList<String> ans2=permuteSpace(input, output);
        System.out.println(ans2);

    }
    
}
