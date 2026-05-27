package Backtracking;

import java.util.ArrayList;

public class NdigitNumbersWithNumberInIncreasingOrder {
    static ArrayList<String> solve(int inputN,String ansSofar){
        ArrayList<String> ans=new ArrayList<>();
        if(inputN==0){
            ArrayList<String> base=new ArrayList<>();
            base.add(ansSofar);
            return base;
        }
        for(int i=0;i<10;i++){
            if(ansSofar.isEmpty()){
                //only when input is string is empty and input is 1 we are cosidering 0 as staring digit
                if(i==0 && inputN!=1){
                    continue;
                }
                ans.addAll(solve(inputN-1, ansSofar+i));
            }
            else{
                int prev=ansSofar.charAt(ansSofar.length()-1)-'0';
              
                if(i>prev){
                    ans.addAll(solve(inputN-1, ansSofar+i));
                }
            }

        } 
        return ans;
         }
//did this method to demonstrate undo mechanism
          static ArrayList<Integer> solve(int inputN,ArrayList<Integer> ansSofar){
        ArrayList<Integer>  ans= new ArrayList<>();
        if(inputN==0){
            //at base just converting ans which is form of arraylist to a number
         ArrayList<Integer> base=new ArrayList<>();
         int num=0;
         for(int i=0;i<ansSofar.size();i++){
            num=num*10+ansSofar.get(i);

         }
         base.add(num);
            return base;
        }
        for(int i=0;i<10;i++){
            if(ansSofar.isEmpty()){
                //only when input is string is empty and input is 1 we are cosidering 0 as staring digit
                if(i==0 && inputN!=1){
                    continue;
                }
                ansSofar.add(i);
                ans.addAll(solve(inputN-1, ansSofar));
                 //backtracking
                ansSofar.remove(ansSofar.size()-1);
            }
            else{
                int prev=ansSofar.get(ansSofar.size()-1)-'0';
              
                if(i>prev){
                     ansSofar.add(i);
                    ans.addAll(solve(inputN-1, ansSofar));
                    //backtracking
                        ansSofar.remove(ansSofar.size()-1);
                }
            }

        } 
        return ans;
         }

    public static void main(String[] args) {
        int n=2;
        ArrayList<String> ans=solve(n, "");
        System.out.println(ans);
        ArrayList<Integer> ans1=solve(n, new ArrayList<>());
        for(Integer num:ans1){
            System.out.println(num);
        }
    }
    
}
