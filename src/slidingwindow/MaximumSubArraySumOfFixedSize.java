package slidingwindow;

/**
 * Find max sun sub array of size K
 * input array: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 * max sum: 16(7, 8, 1)
 * <p>
 * T(n) = O(n)
 */
public class MaximumSubArraySumOfFixedSize {

    public static int findMaxSum(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (i >= k - 1) {
                maxValue = Math.max(maxValue, currSum);
                currSum -= arr[i - (k - 1)];
            }
        }


        return maxValue;
    }

    //Time Complexity = O(n)


    public static void main(String[] args) {
        System.out.println(MaximumSubArraySumOfFixedSize.findMaxSum(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
    }
}
