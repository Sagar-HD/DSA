package basics;

import java.util.Stack;

public class StackAsCalculator {

    static int getAns(String[] input){

    Stack<Integer> stack = new Stack<>();

    for(String item : input){

        if(!isOperand(item)){
            stack.push(Integer.parseInt(item));
        }
        else{

            if(stack.size() < 2){
                System.out.println("Invalid Expression");
                return -1;
            }

            int b = stack.pop();
            int a = stack.pop();

            switch(item){

                case "+":
                    stack.push(a+b);
                    break;

                case "-":
                    stack.push(a-b);
                    break;

                case "*":
                    stack.push(a*b);
                    break;

                case "/":
                    stack.push(a/b);
                    break;
            }
        }
    }

    return stack.peek();
}

static boolean isOperand(String item){

    return item.equals("+")
        || item.equals("-")
        || item.equals("*")
        || item.equals("/");
}

    public static void main(String[] args) {
        String[] task={"2","1","+","3","*"};
        System.out.println(getAns(task));
    }

}
