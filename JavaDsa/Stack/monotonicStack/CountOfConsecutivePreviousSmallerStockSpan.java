package monotonicStack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * CountOfConsecutivePreviousSmallerStockSpan
 */
//this problem is used to tell , todays stock price is higher since past n days 
//means in past n days we never had more than this price for staock 
//this problem asks me no of consecutive smaller elemnts previous me including me 
// in directly it asks who is first next greater to my left 
//if we find greater to left the remaining from him to me are smaller than or equal to me 
public class CountOfConsecutivePreviousSmallerStockSpan {
    static ArrayList<Integer> getStockSpan(int[] arr){
        ArrayList<Integer> stockSpan=new ArrayList<>();
        //we store index
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
              
                // if we didnt find we can just add 1
                //only today consideration yesterday was higher than today

                
                //stockSpan.add(1);

                //or we can consider index as -1 bcs till 0 index no smaller there 
                 int index=-1;

                stockSpan.add(i-index);

            }
            else{
                //days from today to peek day 
                stockSpan.add(i-stack.peek());
            }

            stack.add(i);


        }
        return stockSpan;
    }
    public static void main(String[] args) {
        int[] arr={100,80,60,60,70,75,85};
        System.out.println(getStockSpan(arr));
    }

    
}