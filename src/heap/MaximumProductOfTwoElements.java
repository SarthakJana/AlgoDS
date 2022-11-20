package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductOfTwoElements {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }

        int firstMax = maxHeap.poll();
        int secondMax = maxHeap.poll();

        return (firstMax - 1) * (secondMax - 1);
    }
}
