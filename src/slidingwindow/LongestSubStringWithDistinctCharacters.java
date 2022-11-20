package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithDistinctCharacters {

    private static int findLongestSubString(String string, int k) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int end = 0; end < string.length(); end++) {
            char c = string.charAt(end);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

            if (charMap.size() == k) {
                maxLength = Math.max(maxLength, end - left + 1);
            } else if (charMap.size() > k) {
                while (charMap.size() > k) {
                    char s = string.charAt(left);
                    if (charMap.get(s) == 1) {
                        charMap.remove(s);
                    } else {
                        charMap.put(s, charMap.get(s) - 1);
                    }

                    left++;
                }
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLongestSubString("aaahhibc", 2));
    }
}
