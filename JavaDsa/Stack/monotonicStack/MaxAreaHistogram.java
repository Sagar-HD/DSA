package monotonicStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class MaxAreaHistogram {
    static int getMaxArea(int[] arr){
        // to get area of histogram we need to find histogram from each block 
        // by finding left smaller and right smaller we can get width of histogram and height is cureent block 
        // bcs we can expand histogram until we have greater blocks in right and left so find smaller bloack is when we stop 

        ArrayList<Integer> leftSmaller=new ArrayList<>();
        ArrayList<Integer> rightSmaller=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                leftSmaller.add(-1);
                //psuedo index imagining elemnt at -1 is smaller to get calculation from 0 th index 

            }
            else{
                leftSmaller.add(stack.peek());
            }
            stack.push(i);
        }
      stack.clear();
        // finding right smaller 
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightSmaller.add(arr.length);
                //adding pseudo index as 1 more index than last elem 
            }
            else{
                rightSmaller.add(stack.peek());
            }
            stack.push(i);

        }
        Collections.reverse(rightSmaller);
        //reversing bcs we stored in reverse order 
          int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int area=(rightSmaller.get(i)-leftSmaller.get(i)-1)*arr[i];
            maxArea=Math.max(maxArea, area);

        }

 return maxArea;
    }
    public static void main(String[] args) {
        int[] arr={2 ,1 ,5 ,6 ,2 ,3};
        System.out.println(getMaxArea(arr));
    }
    
}
