package slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
 * such that every character in t (including duplicates) is included in the window. If there is no such
 * substring, return the empty string "".
 * <p>
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubString {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> wMap = new HashMap<>();
        int need, have = 0;
        int[] indices = new int[2];
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        need = tMap.values().stream().reduce(0, Integer::sum);

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && tMap.get(c).equals(wMap.getOrDefault(c, 0))) {
                have++;
            }

            while (have == need) {
                if (minLength > (right - left + 1)) {
                    minLength = right - left + 1;
                    indices[0] = left;
                    indices[1] = right;
                }

                char lc = s.charAt(left);
                wMap.put(lc, wMap.get(lc) - 1);
                if (tMap.containsKey(lc) && wMap.getOrDefault(lc, 0) < tMap.get(lc)) {
                    have--;
                }

                left++;
            }
        }
        return s.substring(indices[0], indices[1] + 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(minWindow("ADOBECODEBANC", "ABC")));
    }
}
