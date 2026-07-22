package basics;

import java.util.Stack;

public class QueueUsingStacksInsertionEffecient {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public boolean isEmpty(){
        return stack1.isEmpty();
    }

    public void push(int i){
        stack1.push(i);
    }

    public int pop(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int removed=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return removed;
    }
  public int peek(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int top=stack2.peek();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return top;
    }

    public static void main(String[] args) {
        QueueUsingStacksInsertionEffecient queue=new QueueUsingStacksInsertionEffecient();
        queue.push(1);
         queue.push(2);
         System.out.println(queue.peek());
           queue.push(3);
         queue.push(4);
         System.out.println(queue.pop());
          while (!queue.isEmpty()) {
            System.out.println(queue.pop());
            
          }
         
        

    }
    
}
