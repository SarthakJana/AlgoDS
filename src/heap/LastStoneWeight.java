package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if (stones.length == 1) {
            return stones[0];
        }

        //O(log(n))
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();//O(log(n))
            int y = maxHeap.poll();//O(log(n))

            if (x != y) {
                maxHeap.add(Math.abs(x - y));//O(log(n))
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{1}));
    }
}
