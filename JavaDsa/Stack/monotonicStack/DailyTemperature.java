package monotonicStack;

import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        if (temperatures.length == 0) {
            return ans;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek() - i;
            } else {
                ans[i] = 0;
            }

            stack.push(i);

        }

        return ans;

    }

    public static void main(String[] args) {
        int[] temps={73,74,75,71,69,72,76,73};
        int[] ans=dailyTemperatures(temps);
        for(int i:ans){
            System.out.print(i+" ");
        }

    }

}
