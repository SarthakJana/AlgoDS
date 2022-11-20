package heap;

import java.util.*;


//Use bucket sort for better performance
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        int[] result = new int[k];

        //O(n)
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //O(dlog(k))
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }

        //O(kLog(k))
        for (int i = k; !minHeap.isEmpty(); i--) {
            result[i] = minHeap.poll().getKey();
        }

        return result;
    }
}