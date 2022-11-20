package slidingwindow;

import java.util.HashMap;

/**
 * LC 424:
 * You are given a string s and an integer k. You can choose any character of the string and change it
 * to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing
 * the above operations.
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 */

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> fMap = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        int freq = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            fMap.put(c, fMap.getOrDefault(c, 0) + 1);

            freq = Math.max(freq, fMap.getOrDefault(c, 0));


            while (((right - left + 1) - freq) > k) {
                char lc = s.charAt(left);
                fMap.put(c, fMap.getOrDefault(lc, 0 ) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABABBA", 2));
    }
}
