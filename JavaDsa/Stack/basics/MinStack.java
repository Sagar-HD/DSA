package basics;

import java.util.Stack;

import javafx.util.Pair;

public class MinStack {
    private Stack<Pair<Integer,Integer>> stack=new Stack<>();

    public void push(int num){
        if(stack.isEmpty()){
            stack.push(new Pair<>(num, num));
            return;
        }

        stack.push(new Pair<>(num, Math.min(num,stack.peek().getValue())));


    }
    public int pop(){
        if(!stack.isEmpty()){
            return stack.pop().getKey();
        }
        return -1;
        
    }

    public int top(){
         if(!stack.isEmpty()){
            return stack.peek().getKey();
        }
        return -1;
    }
      public int getMin(){
         if(!stack.isEmpty()){
            return stack.peek().getValue();
        }
        return -1;
    }
    

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(5);
        stack.push(8);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.push(1);
        stack.push(4);
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMin());
    }


    
}
```java
/*
 * Min Stack (O(1) Extra Space)
 *
 * Idea:
 * Instead of storing (value, minimum) as a pair for every element,
 * we store only one integer and maintain a global variable `min`.
 *
 * Normal Push:
 * If the new value >= current minimum, push it normally.
 *
 * New Minimum Push:
 * If the new value becomes the new minimum, we cannot lose the previous
 * minimum. So instead of pushing the actual value, we push an encoded value:
 *
 *      encoded = 2 * newMin - oldMin
 *
 * Why this formula?
 * It mirrors the old minimum across the new minimum:
 *
 *      encoded = newMin - (oldMin - newMin)
 *
 * Since newMin < oldMin,
 *
 *      encoded = 2*newMin - oldMin < newMin
 *
 * Therefore, every encoded value is always STRICTLY smaller than the
 * current minimum, making it an automatic flag.
 *
 * During Top():
 * If stack.peek() >= min, it is a normal value.
 * If stack.peek() < min, it is an encoded value, so the actual top element
 * is the current minimum.
 *
 * During Pop():
 * If the popped value >= min, it is a normal element.
 * If the popped value < min, it is encoded, meaning the current minimum
 * is being removed.
 *
 * The previous minimum is restored using:
 *
 *      oldMin = 2 * currentMin - encoded
 *
 * This comes directly from rearranging:
 *
 *      encoded = 2 * newMin - oldMin
 *
 * Example:
 *      oldMin = 5
 *      push(2)
 *
 *      encoded = 2*2 - 5 = -1
 *
 * Stack stores:
 *      -1
 *
 * Current min = 2
 *
 * Since -1 < 2, we know it is encoded.
 *
 * During pop:
 *
 *      oldMin = 2*2 - (-1) = 5
 *
 * Thus, the previous minimum is recovered in O(1) time without using
 * an additional stack.
 */
```
