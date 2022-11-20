package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 438
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class FindAllAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        int[] sHash = new int[26];
        int[] pHash = new int[26];
        List<Integer> indices = new ArrayList<>();
        int left = 0, right = 0;
        int window = p.length();

        while (right < window) {
            sHash[s.charAt(right) - 'a']++;
            pHash[s.charAt(right) - 'a']++;
            right++;
        }

        right--;

        while (right < s.length()) {
            if (Arrays.equals(sHash, pHash)) {
                indices.add(left);
            }

            if (++right != s.length())
                sHash[s.charAt(right) - 'a']++;

            sHash[s.charAt(left++) - 'a']--;
        }

        return indices;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(findAnagrams("aa", "bb")));
    }
}
