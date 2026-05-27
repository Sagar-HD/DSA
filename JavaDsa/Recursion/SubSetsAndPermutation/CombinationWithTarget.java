package SubSetsAndPermutation;

import java.util.ArrayList;
//important

// this problem is solved using 2 type of thing
// first 2 methods think like making decision on array element , to take or not take to get answer
// in third method using backtracking we are thinking like which element to take to get my answer where we have variable choices we backtrack and get answer 
// this is where one or binary choice turns into variable choices
// 2 choices vs variable choices and controlled recursion

public class CombinationWithTarget {
    //include or exclude
     static void possibleCombinations(int[] list,int index,ArrayList<Integer> ans,int target){
        
         if(index==list.length || target<0 ){
            return;
         }
        if(target==0){
        System.out.println(ans);
        return;
        }
      
           
            ans.add(list[index]);
            possibleCombinations(list,index, ans,target-list[index]);
            ans.remove(ans.size()-1);
            possibleCombinations(list,index+1, ans,target);
            
        }
        //include or exclude
        static void possibleCombinationsUnique(int[] list,int index,ArrayList<Integer> ans,int target){
        
         if(index==list.length || target<0 ){
            return;
         }
        if(target==0){
        System.out.println(ans);
        return;
        }
      
           
            ans.add(list[index]);
             possibleCombinationsUnique(list,index+1, ans,target-list[index]);
            ans.remove(ans.size()-1);
           possibleCombinationsUnique(list,index+1, ans,target);
            
        }
        // i think this is the best approach to solve this question 
         static void possibleCombination2(int[] list,int index,ArrayList<Integer> ans,int target){
        
         if(index==list.length || target<0 ){
            return;
         }
        if(target==0){
        System.out.println(ans);
        return;
        }
      
           for(int i=index;i<list.length;i++){
               ans.add(list[i]);
              possibleCombination2(list, i, ans, target-list[i]);
              ans.remove(ans.size()-1);

           }
            
            
        }
    public static void main(String[] args) {
           int[] list={1,2,3,4,5};
       
        possibleCombinations(list,0,new ArrayList<>(),4);
        System.out.println("/// unique comb");
        possibleCombinationsUnique(list, 0, new ArrayList<>(), 4);
        System.out.println("backtracking method");
        possibleCombination2(list, 0, new ArrayList<>(), 4);
    }
}
