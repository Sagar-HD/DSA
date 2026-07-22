package monotonicStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerRight {
    static ArrayList<Integer> getNextSmallerRight(int[] arr){
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0);
            }
            else{
                ans.add(stack.peek());
            }
            stack.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;
        
    }
    public static void main(String[] args) {
         int[] temps={73,74,75,71,69,72,76,73};
         System.out.println(getNextSmallerRight(temps));

        
    }
    
}
