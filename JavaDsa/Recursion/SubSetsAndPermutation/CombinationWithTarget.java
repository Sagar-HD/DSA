package SubSetsAndPermutation;

import java.util.ArrayList;

public class CombinationWithTarget {
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
    public static void main(String[] args) {
           int[] list={1,2,3,4,5};
       
        possibleCombinations(list,0,new ArrayList<>(),4);
        System.out.println("/// unique comb");
        possibleCombinationsUnique(list, 0, new ArrayList<>(), 4);
    }
}
