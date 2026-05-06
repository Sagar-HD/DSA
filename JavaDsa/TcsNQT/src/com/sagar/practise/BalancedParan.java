package com.sagar.practise;

import java.util.Stack;

public class BalancedParan {
    static boolean isMatch(char a, char b){
        if(a=='{'&&b=='}'){
            return true;
        }
        else if(a=='['&&b==']'){
            return true;
        }
        else if(a=='('&&b==')'){
            return true;
        }
        return false;

    }
    public static void main(String[] args) {
        String para="(([[]}))";
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<para.length();i++)
        {
            if(para.charAt(i)=='('||para.charAt(i)=='{'||para.charAt(i)=='[') {
                stack.push(para.charAt(i));
            }
            else{
                if(!stack.isEmpty()){
                    if(isMatch(stack.peek(),para.charAt(i))){
                        stack.pop();
                    }
                    else{
                        System.out.println("invalid paran not matching at"+para.charAt(i)+" in stack "+stack.peek()  );
                        break;
                    }
                }
                else{
                    System.out.println("invalid paran due to closing without opening"  );
                    break;
                }
            }

        }
        if(stack.isEmpty()){
            System.out.println("valid paran"  );
        }
        else{
            System.out.println("invalid paran"  );
        }
    }
}
