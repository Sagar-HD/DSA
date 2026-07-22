package monotonicStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class maxAreaInBinaryMatrix {
    static int getMaxArea(int[][] matrix){
        if(matrix.length==0) return 0;
        ArrayList<Integer> histo=new ArrayList<>();
        for(int i=0;i<matrix[0].length;i++){
            histo.add(matrix[0][i]);
        }
        int maxArea=histogramMaxArea(histo);

        for(int i=1;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
            if(matrix[i][j]==0){
                histo.set(j, 0);

            }
            else{
                histo.set(i, histo.get(i)+1);
            }
           }
           maxArea=Math.max(maxArea, histogramMaxArea(histo));
        }
      
        return maxArea;

    }
    static int histogramMaxArea(ArrayList<Integer> histogram){
        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> leftIndexes=new ArrayList<>();
        ArrayList<Integer> rightIndexes=new ArrayList<>();

        for(int i=0;i<histogram.size();i++){

            while(!stack.isEmpty() && histogram.get(stack.peek())>=histogram.get(i) ){
                stack.pop();
            }
            if(stack.isEmpty()){
                leftIndexes.add(-1);
            }
            else{
                leftIndexes.add(stack.peek());
            }

            stack.add(i);

        }
        stack.clear();
           for(int i=histogram.size()-1;i>=0;i--){

            while(!stack.isEmpty() && histogram.get(stack.peek())>=histogram.get(i) ){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightIndexes.add(histogram.size());
            }
            else{
                rightIndexes.add(stack.peek());
            }
            
            stack.add(i);

        }
        Collections.reverse(rightIndexes);
       int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<histogram.size();i++){
            int area=histogram.get(i)*(rightIndexes.get(i)-leftIndexes.get(i)-1);
            maxArea=Math.max(maxArea, area);
        }

        return maxArea;

    }
    public static void main(String[] args) {
        int[][] matrix = {
    {1, 0, 1, 0, 0},
    {1, 0, 1, 1, 1},
    {1, 1, 1, 1, 1},
    {1, 0, 0, 1, 0}


};
System.out.println(getMaxArea(matrix));
    }
    
}
