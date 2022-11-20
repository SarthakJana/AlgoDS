package heap;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder stringBuilder = new StringBuilder();

        if (s.length() == 1) {
            return s;
        }

        //O(n)
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //O(n)
        maxHeap.addAll(map.entrySet());

        //O(nlog(n))
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                stringBuilder.append(entry.getKey());
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(frequencySort.frequencySort("aaacc"));
    }
}
