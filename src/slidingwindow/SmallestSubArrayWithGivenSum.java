package slidingwindow;

public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int[] arr, int target) {
        int ws = 0;
        int we = 0;
        int currSum = 0;
        int minWinSize = Integer.MAX_VALUE;

        for ( int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            we = i;

            while (currSum >= target) {
                minWinSize = Math.min(we - ws + 1, minWinSize);
                currSum -= arr[ws++];
            }
        }

        return minWinSize;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubArray(new int[]{4, 2, 2, 7, 8, 1, 2, 8, 10}, 8));
    }
}
