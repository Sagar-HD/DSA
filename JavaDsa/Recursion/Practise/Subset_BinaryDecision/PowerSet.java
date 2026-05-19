package Practise.Subset_BinaryDecision;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static List<List<Integer>> powerSet(int[] arr, int index,ArrayList<Integer> processed){
        if(index==arr.length){
            List<List<Integer>> ans=new ArrayList<>();
            ans.add(new ArrayList<>(processed));
            return ans;



        }
  
    List<List<Integer>> exclude=powerSet(arr, index+1,processed);
      processed.add(arr[index]);
    List<List<Integer>> include=powerSet(arr, index+1,processed);
    processed.remove(processed.size()-1);
    exclude.addAll(include);
    return exclude;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        ArrayList<Integer> processed=new ArrayList<>();
        List<List<Integer>> ans=powerSet(arr, 0, processed);
        for(List<Integer> sub :ans){
            System.out.println(sub);
        }

    }
    
}
