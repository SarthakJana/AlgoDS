package stackdatastructure;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToLeft {

    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.add(arr[i]);
            } else if (stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[i] = -1;
                    stack.add(arr[i]);
                } else {
                    result[i] = stack.peek();
                    stack.add(arr[i]);
                }
            } else if (stack.peek() > arr[i]) {
                result[i] = stack.peek();
                stack.add(arr[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4})));
    }
}
