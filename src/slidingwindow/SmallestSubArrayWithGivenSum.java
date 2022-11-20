package slidingwindow;

public class SmallestSubArrayWithGivenSum {

    public static int smallestSubArray(int[] arr, int target) {
        int minWindowSize = Integer.MAX_VALUE;
        int currSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];

            while (currSum >= target) {
                minWindowSize = Math.min(minWindowSize, end - start + 1);
                currSum -= arr[start];
                start++;
            }
        }
        //4, 2, 2, 7, 8, 1, 2, 8, 10


        return minWindowSize;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubArray(new int[]{4, 2, 2, 7, 8, 1, 2, 8, 10}, 8));
    }
}
