package LeetCode;
import java.util.*;
class Solution {
    public int[] findErrorNums(int[] nums) {
       
        HashSet<Integer> set=new HashSet<>();
        
        int arraySum=0;
        int duplicate=-1;
        for(int i:nums){
           
            if(!set.contains(i)){
                set.add(i);
            }
            else{
                duplicate=i;
            }
          
            arraySum+=i;
        }
          System.out.println("duplicate "+duplicate);
         
        int actualSum=0;
        for(int i=1;i<=nums.length;i++){
            actualSum+=i;
        }
        
           
        int missing = actualSum-(arraySum-duplicate);
       int[] ans=new int[2];
       ans[0]=duplicate;
       ans[1]=missing;
        return ans;

    }
}