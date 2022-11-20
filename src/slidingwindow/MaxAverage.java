package slidingwindow;

public class MaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        double currSum = 0;
        double maxAvg = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (i >= k - 1) {
                maxAvg = Math.max(maxAvg, currSum / k);
                currSum -= nums[i - (k - 1)];
            }
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}