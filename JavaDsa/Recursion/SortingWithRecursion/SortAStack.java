package SortingWithRecursion;

import java.util.Stack;

public class SortAStack {
    public static void sort(Stack<Integer> stack){
    if(stack.size()==1){
        return;
    }
    int num=stack.pop();
    sort(stack);
    insert(stack,num);
    }
    public static void insert(Stack<Integer> sortedStack,Integer elementToInsert){
        if(sortedStack.size()<=0 || sortedStack.peek()<=elementToInsert){
        sortedStack.push(elementToInsert);
        return;
        }
        int maxElem=sortedStack.pop();
        insert(sortedStack,elementToInsert);
        sortedStack.push(maxElem);
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        stack.push(50);
        stack.push(10);
        stack.push(30);
        stack.push(25);
        sort(stack);
        System.out.println(stack);
    }
    
}
