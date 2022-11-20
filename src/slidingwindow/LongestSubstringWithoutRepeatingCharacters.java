package slidingwindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 3:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(findLongestSubstringNonRepeating("abcabcbb"));
    }

    private static int findLongestSubstringNonRepeating(String s) {
        int left = 0;
        int maxSubstring = Integer.MIN_VALUE;
        Set<Character> distinctChars = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (distinctChars.contains(s.charAt(right))) {
                distinctChars.remove(s.charAt(right));
                left++;
            }

            distinctChars.add(s.charAt(right));
            maxSubstring = Math.max(maxSubstring, distinctChars.size());
        }

        return maxSubstring;
    }
}
