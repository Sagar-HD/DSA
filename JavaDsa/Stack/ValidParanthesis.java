import java.util.*;

public class ValidParanthesis {
     static int isOpening(char ch){
       if(ch=='(' || ch=='{' || ch=='['){
         return 1;
       }
       else if(ch==')' || ch=='}' || ch==']'){
         return 0;
       }
       else{
         return -1;
       }
     }
     static char get(char ch){
       if(ch==')') return '(';
       if(ch=='}') return '{';
       if(ch==']') return '[';
       return '#';
       
     }
    public static void main(String[] args) {
      Stack<Character> stack=new Stack<>();
      String str="(({[]}))"; 
    
      for(int i=0;i<str.length();i++){
        if(isOpening(str.charAt(i))==1){
          stack.push(str.charAt(i));
        }
        else if(isOpening(str.charAt(i))==0)
        {
          if(stack.empty()){
            System.out.println("inavlid");
            return;
          }
          Boolean isValid=stack.peek()==get(str.charAt(i));
          if(isValid){
            
            stack.pop();
          }
          else{
            System.out.println("invalid");
            return ;
          }
        }
        else{
          System.out.println("invalid char");
        }
      }
      if(stack.empty()){
        System.out.println("valid paranthesis ");
        return ;
      }
      System.out.println("invalid ");
    }
}