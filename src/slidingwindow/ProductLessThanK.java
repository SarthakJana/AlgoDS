package slidingwindow;

public class ProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int currProduct = 1;
        int count = 0;
        int windowStart = 0;

        if (k <= 1) {
            return 0;
        }

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currProduct *= nums[windowEnd];
            while (currProduct >= k && windowStart < nums.length ) {
                currProduct /= nums[windowStart++];
            }

            count += windowEnd - windowStart + 1;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }
}
