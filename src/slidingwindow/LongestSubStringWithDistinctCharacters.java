package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithDistinctCharacters {

    private static int findLongestSubString(String string, int k) {
        int maxLength = Integer.MIN_VALUE;
        int ws = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int we = 0; we < string.length(); we++) {
            char c = string.charAt(we);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() == k) {
                maxLength = Math.max(maxLength, we - ws + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    if (map.get(string.charAt(ws)) == 1) {
                        map.remove(string.charAt(ws));
                    } else {
                        map.put(string.charAt(ws), map.get(string.charAt(ws)) - 1);
                    }

                    ws++;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubString("aaahhibc", 2));
    }
}
