package slidingwindow;

/**
 * Find max sun sub array of size K
 * input array: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
 * max sum: 16(7, 8, 1)
 *
 * T(n) = O(n)
 */
public class MaximumSubArraySum {

    public static int findMaxSum(int[] arr, int k) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= arr[i - (k - 1)];
            }
        }

        return maxSum;
    }

    //Time Complexity = O(n)


    public static void main(String[] args) {
        System.out.println(MaximumSubArraySum.findMaxSum(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
    }
}
