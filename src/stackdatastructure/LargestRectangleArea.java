package stackdatastructure;

import java.util.Stack;

public class LargestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        int[] nearestSmallerToRight = getNearestSmallerToRight(heights);
        int[] nearestSmallerTOLeft = getNearestSmallerToLeft(heights);
        int[] area = new int[heights.length];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int width = nearestSmallerToRight[i] - nearestSmallerTOLeft[i] - 1;
            area[i] = width * heights[i];
        }

        for (int i = 0; i < heights.length; i++) {
            if (area[i] > max) {
                max = area[i];
            }
        }

        return max;
    }

    private static int[] getNearestSmallerToRight(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[heights.length];
        int[] reversedResult = new int[heights.length];
        int pseudoIndex = heights.length;

        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                reversedResult[i] = pseudoIndex;
                stack.push(new Pair(i, heights[i]));
            } else if (stack.peek().value < heights[i]) {
                reversedResult[i] = stack.peek().index;
                stack.push(new Pair(i, heights[i]));
            } else if (stack.peek().value >= heights[i]) {
                while (!stack.isEmpty() && stack.peek().value >= heights[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    reversedResult[i] = pseudoIndex;
                    stack.push(new Pair(i, heights[i]));
                } else {
                    reversedResult[i] = stack.peek().index;
                    stack.push(new Pair(i, heights[i]));
                }
            }
        }

        return reversedResult;
    }

    private static int[] getNearestSmallerToLeft(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int[] result = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(new Pair(i, heights[i]));
            } else if (stack.peek().value < heights[i]) {
                result[i] = stack.peek().index;
                stack.push(new Pair(i, heights[i]));
            } else if (stack.peek().value >= heights[i]) {
                while (!stack.isEmpty() && stack.peek().value >= heights[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                    stack.push(new Pair(i, heights[i]));
                } else {
                    result[i] = stack.peek().index;
                    stack.push(new Pair(i, heights[i]));
                }
            }
        }

        return result;
    }

    public static class Pair {
        public int index;
        public int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 4}));
    }
}
