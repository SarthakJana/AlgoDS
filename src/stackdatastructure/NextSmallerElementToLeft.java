package stackdatastructure;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElementToLeft {

    public static int[] solution(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                addValue(arr, result, stack, i, -1);
            } else if (stack.peek() < arr[i]) {
                addValue(arr, result, stack, i, stack.peek());
            } else if (stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    addValue(arr, result, stack, i, -1);
                } else {
                    addValue(arr, result, stack, i, stack.peek());
                }
            }
        }

        return result;
    }

    private static void addValue(int[] arr, int[] result, Stack<Integer> stack, int i, int val) {
        result[i] = val;
        stack.add(arr[i]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 5, 2, 10, 8})));
    }
}
