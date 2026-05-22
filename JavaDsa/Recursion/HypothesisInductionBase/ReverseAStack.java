package HypothesisInductionBase;

import java.util.Stack;

//IBH for ReverseAStack
/*
hypothesis:
       ReverseAStack(stack)=reversed stack of n 
       ReverseAStack(stack-1)=reversed stack of n-1
Induction:
      ReverseAStack(stack)= ReverseAStack(stack-1)=reversed stack +  insertToFirst(lastelement);
      
Base:
     stack.size()==1
     return;
         
*/
//IBH for insertToFirst(lastelement)
/*
hypothesis:
       insertToFirst(stack,lastelement)=inserted last element to first in stack of size n
       insertToFirst(stack-1,lastelement)=inserted last element to first in stack of size n-1
Induction:
     insertToFirst(stack,lastelement)= insertToFirst(stack-1,lastelement)=inserted to stack of size n-1 +  push(removed element);
      
Base:
     if(stack.isempty())
     {
     stack.push(lastElement);

     return;
    }
         
*/


public class ReverseAStack {
    static void reverse(Stack<Integer> stack){
        if(stack.size()==1){
            return;
        }
        int lastElement=stack.pop();
        reverse(stack);
        insertToFirst(stack,lastElement);

    }
    static void insertToFirst(Stack<Integer> stack,int lastElement){
        if(stack.isEmpty()){
            stack.push(lastElement);
            return;
        }
        int num=stack.pop();
        insertToFirst(stack, lastElement);
        stack.push(num);

    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
          stack.push(2);
         stack.push(3);
        stack.push(4);
        stack.push(5);
        reverse(stack);
        System.out.println(stack);
    }
}
