package HypothesisInductionBase;

import java.util.Stack;

public class RemoveMiddleOfStack {

//IBH for removeKthElement
/*
hypothesis:
       removeKthElement(stack,k)=stack after removing kth element
       removeKthElement(stack-1,k-1)=stack-1 after removing kth-1 element
Induction:
      removeKthElement(stack)= removeKthElement(stack-1,k-1)=stack-1 after removing kth-1 element + then stack.push(last element);
      
Base:
     k==1
     stack.pop();
     return;
         
*/


   
    static void removeKthElement(Stack<Integer> stack,int k){
        if(stack.isEmpty()){
            return;
        }
        if(k==1){
            stack.pop();
            return;
        }
    int num=stack.pop();
    removeKthElement(stack, k-1);
    stack.push(num);

    }


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
 int middle=(stack.size()/2)+1;
 removeKthElement(stack, middle);
 System.out.println(stack);

    }
}