package dynamicprogramming;

public class MaximumSumSubArray {

    public static int maxSum(int[] nums) {
        //int max = nums[0];
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
           currentSum += nums[i];

           if (currentSum < nums[i]) {
               currentSum = nums[i];
           }

           if (max < currentSum) {
               max = currentSum;
           }
        }
        /*for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }*/

        return max;
    }
}
