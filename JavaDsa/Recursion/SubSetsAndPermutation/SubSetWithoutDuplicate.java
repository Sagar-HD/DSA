// need to dry run again and undestand
package SubSetsAndPermutation;

import java.util.ArrayList;
import java.util.Arrays;
// ** important duplicate is allowed in array and subset but not duplicate subsets
public class SubSetWithoutDuplicate {
    static ArrayList<ArrayList<Integer>> findSub(int[] arr,ArrayList<Integer> cur,int index,boolean prevTaken){
    ArrayList<ArrayList<Integer>> finalAns=new ArrayList<>();
       
       if(index==arr.length){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> thisLevelAns=new ArrayList<>(cur);
        ans.add(thisLevelAns);
        return ans;
       }
        ArrayList<ArrayList<Integer>> exclude=findSub(arr, cur, index+1,false);
          finalAns.addAll(exclude);
       if(index==0 || arr[index]!=arr[index-1] || prevTaken)
       {
       
       cur.add(arr[index]);
       ArrayList<ArrayList<Integer>> include=findSub(arr, cur, index+1,true);
       cur.remove(cur.size()-1);
        finalAns.addAll(include);
      
       }
       else{
          
       }
      
     
      return finalAns;
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,2,3,4};
        Arrays.sort(arr);
ArrayList<ArrayList<Integer>> ans=findSub(arr, new ArrayList<>(), 0,false);
for(ArrayList<Integer> li: ans){
System.out.println(li);
}

    }
}

//important----
// i was doing ans.add(cur) before this will add the ref of cur to ans not copy of it
// so after backtracking at end nothing will be added 