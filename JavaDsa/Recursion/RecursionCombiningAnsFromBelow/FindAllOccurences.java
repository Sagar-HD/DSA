package RecursionCombiningAnsFromBelow;

import java.util.ArrayList;

public class FindAllOccurences {
    
    static ArrayList<Integer> find2(int[] arr,int target,int index){
        ArrayList<Integer> list=new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
           
        }
        ArrayList<Integer> otherList=find2(arr,target,index+1);
        list.addAll(otherList);
        return list;
    }
    public static void main(String[] args) {
         int[] arr={2,1,3,4,5,1,3,2,9,3};
         System.out.println(find2(arr, 3, 0));
    }
    
}
