package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        LinkedList<Integer> dequeue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        while (right < nums.length) {
            while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[right])
                dequeue.pop();

            dequeue.add(right);

            if (left > dequeue.peekFirst())
                dequeue.removeFirst();

            if ((right + 1) >= k) {
                result.add(nums[dequeue.peekFirst()]);
                left++;
            }

            right++;
        }

        int[] maxSlidingWindow = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            maxSlidingWindow[i] = result.get(i);
        }

        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
