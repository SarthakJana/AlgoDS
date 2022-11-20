package dynamicprogramming;

import java.util.Arrays;

public class SmallestPositiveInteger {
    public int solution(int[] A) {
        int num = 0;

        Arrays.sort(A);
        int min = 1;

        for (int i : A) {
            if (i == min) {
                min++;
            }
        }

        return min;
    }
}
