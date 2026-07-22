package basics;

import java.util.Stack;

public class MinStackConstantSpace {
    Stack<Integer> stack = new Stack<>();
    int min = 0;

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (stack.peek() >= min) {
            return stack.peek();
        } else {
            return min;
        }
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return min;
    }

    private void push(int i) {
        if (stack.isEmpty()) {
            stack.push(i);
            min = i;
        } else {
            if (i >= min) {
                stack.push(i);
            } else {
                stack.push(2 * i - min);
                min = i;
            }
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek() >= min) {
                stack.pop();
            } else {
                int poped = stack.pop();

                min = 2 * min - poped;;
            }

        }

    }

    public static void main(String[] args) {
        MinStackConstantSpace stack = new MinStackConstantSpace();
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
