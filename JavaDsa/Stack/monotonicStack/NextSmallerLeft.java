package monotonicStack;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerLeft {
     static ArrayList<Integer> getNextSmallerLeft(int[] arr){
         ArrayList<Integer> ans=new ArrayList<>();
         Stack<Integer> stack=new Stack<>();
         for(int i : arr){
            while(!stack.isEmpty() && stack.peek()>=i){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0);
            }
            else{
                ans.add(stack.peek());
            }
            stack.push(i);

         }


         return ans;

    }
    public static void main(String[] args) {
         int[] arr={9,3,2,8,4,3,6};
         System.out.println(getNextSmallerLeft(arr));
    }
    
}
