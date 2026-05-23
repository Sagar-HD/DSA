package Other.Subset_BinaryDecision;

import java.util.ArrayList;

public class ValidParanthesis {
    //in this method out of choices i have iam making only valid decisions
    static ArrayList<String> validParanthesis(String output,int n,int noOfOpen,int noOfClose){
        ArrayList<String> ans=new ArrayList<>();
        if(output.length()==n*2){
            ArrayList<String> sub=new ArrayList<>();
            sub.add(output);
            return sub;
        }
        if(noOfOpen<n){
     ans.addAll(validParanthesis(output+'(', n, noOfOpen+1, noOfClose));
        }
        if(noOfClose<noOfOpen){
       ans.addAll(validParanthesis(output+')', n, noOfOpen, noOfClose+1));
        }
        return ans;
    }
    // in this method we are making all decision out of all choiced both valid and invalid , and stopping it in base condition
        static ArrayList<String> validParanthesis2(String output,int n,int noOfOpen,int noOfClose){
        ArrayList<String> ans=new ArrayList<>();

         if(noOfOpen>n || noOfClose>noOfOpen){
            ArrayList<String> noAns=new ArrayList<>(); 
            return noAns;
        }
        if(output.length()==n*2){
            ArrayList<String> sub=new ArrayList<>();
            sub.add(output);
            return sub;
        }
       
        
     ans.addAll(validParanthesis2(output+'(', n, noOfOpen+1, noOfClose));
     ans.addAll(validParanthesis2(output+')', n, noOfOpen, noOfClose+1));
        
        return ans;
    }
    public static void main(String[] args) {
        int n=3;
        ArrayList<String> ans=validParanthesis("", n, 0, 0);
        System.out.println(ans);
        

          ArrayList<String> ans2=validParanthesis2("", n, 0, 0);
        System.out.println(ans2);

    }
    
}
