package stackdatastructure;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                answer[i] = i;
                stack.push(i);
            } else if (temperatures[stack.peek()] > temperatures[i]) {
                answer[i] = stack.peek();
                stack.push(i);
            } else if (temperatures[stack.peek()] <= temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    answer[i] = i;
                    stack.push(i);
                } else {
                    answer[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i] - i;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
    }
}
