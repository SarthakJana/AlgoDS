package stackdatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> intStack = new Stack<>();
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        ArrayList<Integer> nextGreaterElements = new ArrayList<>();
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (intStack.isEmpty()) {
                nextGreaterElements.add(-1);
                intStack.add(nums2[i]);
            } else if (intStack.peek() > nums2[i]) {
                nextGreaterElements.add(intStack.peek());
                intStack.add(nums2[i]);
            } else if (intStack.peek() < nums2[i]) {
                while (!intStack.isEmpty() && intStack.peek() <= nums2[i]) {
                    intStack.pop();
                }
                if (intStack.isEmpty()) {
                    nextGreaterElements.add(-1);
                    intStack.add(nums2[i]);
                } else {
                    nextGreaterElements.add(intStack.peek());
                    intStack.add(nums2[i]);
                }
            }
        }

        int start = 0;
        int end = nextGreaterElements.size() - 1;

        while (start < end) {
            int temp = nextGreaterElements.get(start);
            nextGreaterElements.add(start, nextGreaterElements.get(end));
            nextGreaterElements.add(end, temp);
            start++;
            end--;
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterElements.get(indexMap.get(nums1[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
