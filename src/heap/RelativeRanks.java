package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> scoreIndex = new HashMap<>();
        String[] ranks = new String[score.length];

        for (int i = 0; i < score.length; i++) {
            scoreIndex.put(score[i], i);
            maxHeap.add(score[i]);
        }

        for (int i = 0; i < score.length; i++) {
            int scr = 0;
            switch (i) {
                case 0:
                    scr = maxHeap.poll();
                    ranks[scoreIndex.get(scr)] = "Gold Medal";
                    break;
                case 1:
                    scr = maxHeap.poll();
                    ranks[scoreIndex.get(scr)] = "Silver Medal";
                    break;
                case 2:
                    scr = maxHeap.poll();
                    ranks[scoreIndex.get(scr)] = "Bronze Medal";
                    break;
                default:
                    scr = maxHeap.poll();
                    ranks[scoreIndex.get(scr)] = String.valueOf(i + 1);
            }
        }

        return ranks;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
    }
}
