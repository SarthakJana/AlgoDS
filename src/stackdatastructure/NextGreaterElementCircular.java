package stackdatastructure;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementCircular {

    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(result, -1);

        for (int i = 0; i < 2 * length; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % length];
            }

            if (i < length) {
                stack.push(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
    }
}