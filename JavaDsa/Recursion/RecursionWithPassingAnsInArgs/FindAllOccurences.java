package RecursionWithPassingAnsInArgs;
import java.util.*;
public class FindAllOccurences {
    static void find(int[] arr,int target,int index,ArrayList<Integer> list){
        if(index==arr.length){
            return;
        }
        if(arr[index]==target){
            list.add(index);
           
        }
        find(arr,target,index+1,list);
    }
  



    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        int[] arr={2,1,3,4,5,1,3,2,9,3};
        find(arr,3,0,list);
      System.out.println(list);
       
 
    }
}
