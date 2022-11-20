package stackdatastructure;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static int[] solution(int[] arr) {
        int[] index = new int[arr.length];
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                index[i] = -1;
                stack.push(i);
            } else if (arr[stack.peek()] > arr[i]) {
                index[i] = stack.peek();
                stack.push(i);
            } else if (arr[stack.peek()] <= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    index[i] = -1;
                    stack.push(i);
                } else {
                    index[i] = stack.peek();
                    stack.push(i);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result[i] = i - index[i];
        }

        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(new int[]{100, 80, 60, 70, 60, 75, 85})));
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80)); // return 1
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(70)); // return 1
        System.out.println(stockSpanner.next(60)); // return 1
        System.out.println(stockSpanner.next(75)); // return 1
        System.out.println(stockSpanner.next(85)); // return 1
    }
}
