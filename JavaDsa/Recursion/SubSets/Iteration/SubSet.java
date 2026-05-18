package SubSets.Iteration;

import java.util.ArrayList;

public class SubSet {
    static ArrayList<ArrayList<Integer>> findSub(int[] arr){
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
      
        ans.add(new ArrayList<>());

        for(int i:arr){
             ArrayList<ArrayList<Integer>> levelAnswer=new ArrayList<>();
            for(ArrayList<Integer> li : ans){
                ArrayList<Integer> newList = new ArrayList<>(li);
                newList.add(i);
               levelAnswer.add(newList);
            }
        ans.addAll(levelAnswer);
       


        }
        return ans;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        ArrayList<ArrayList<Integer>> ans=findSub(arr);
            for(ArrayList<Integer> li : ans){
                System.out.println(li);
            }
    }
}
