package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
 * substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LCSWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character>set=new HashSet<>();
        int maxLength=0;
        int windowStart=0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){

            if(!set.contains(s.charAt(windowEnd))){
                set.add(s.charAt(windowEnd));
                maxLength=Math.max(maxLength,windowEnd-windowStart+1);

            }else{
                while(s.charAt(windowStart)!=s.charAt(windowEnd)){
                    set.remove(s.charAt(windowStart));
                    windowStart++;
                }
                set.remove(s.charAt(windowStart));windowStart++;
                set.add(s.charAt(windowEnd));
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Longest substring length: " + lengthOfLongestSubstring("abcabcbb"));
    }
}
