package basics;

import java.util.Stack;

public class MinAddToMakeValidParam {
     public static int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();

                }
                else{
                    stack.push(ch);
                }

            }
            else{
                stack.push(ch);
            }
        }
       return stack.size() ;
    }
    public static void main(String[] args) {
        String params="(()(()";
        System.out.println(minAddToMakeValid(params));
    }
    
}
