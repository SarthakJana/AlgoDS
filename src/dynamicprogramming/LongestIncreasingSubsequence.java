package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int findLIS(int[] arr) {
        int[] lis = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < 1 + lis[j]) {
                    lis[i] = 1 + lis[j];
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.findLIS(new int[]{5, 7, 4, -3, 9, 5, 8, 9}));
    }
}
