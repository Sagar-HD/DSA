package greeadyStack;

import java.util.Stack;
//greedy approach of having smaller number first so remving any bigger number if exists

public class removeKdigitsToMakeSmallestNum {
    static String getSmallest(String num, int k) {
        Stack<Character> stack = new Stack<>();

        int index;

        for (index = 0; index < num.length(); index++) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(index) && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(index));

        }
        StringBuilder ans = new StringBuilder("");
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        ans.reverse();

        // still remaining removals
        if (index == num.length() && k > 0) {
            return ans.substring(0, ans.length() - k);
        }

        // else return ans

        return ans.toString();

    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(getSmallest(num, k));
    }

}
