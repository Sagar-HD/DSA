package SubSetsAndPermutation.Iteration;

import java.util.ArrayList;
// starting empty string matters to build up all Permutation
// at each level we building a half ans of all siblings
//in recursion we used to go deep for one sibling until we get ans then add ans then to to other sibling


public class Permutation {
    static ArrayList<String> perm(String str){
ArrayList<String> ans=new ArrayList<>();
ans.add("");
for(int i=0;i<str.length();i++){
    ArrayList<String> newAns=new ArrayList<>();
    for(String oldAns:ans){
        for(int j=0;j<=oldAns.length();j++){
            newAns.add(oldAns.substring(0,j)+str.charAt(i)+oldAns.substring(j,oldAns.length()));

        }
    
    }
    ans=newAns;

   

}
return ans;
    }
    public static void main(String[] args) {
        String str="abc";
    ArrayList<String> ans=perm(str);
    System.out.println(ans);

    }
    
}
