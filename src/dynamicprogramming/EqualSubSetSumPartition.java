package dynamicprogramming;

public class EqualSubSetSumPartition {

    public static boolean canPartition(int[] nums) {
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        int s = total % 2;

        if (s != 0) {
            return false;
        }

        return isSubsetSum(nums, total / 2);
    }

    private static boolean isSubsetSum(int[] nums, int s) {
        boolean[][] sum = new boolean[nums.length + 1][s + 1];

        for (int i = 0; i <= nums.length; i++) {
            sum[i][0] = true;
        }

        for (int i = 1; i <= s; i++) {
            sum[0][1] = false;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= s; j++) {
                if (nums[i - 1] <= j) {
                    sum[i][j] = sum[i - 1][j - nums[i - 1]] || sum[i - 1][j];
                } else {
                    sum[i][j] = sum[i - 1][j];
                }
            }
        }

        return sum[nums.length][s - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        System.out.println(EqualSubSetSumPartition.canPartition(a));
    }
}
