package search;

public class FindMinInRotatedArray {
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length;
        int mid;
        int minValue = Integer.MAX_VALUE;

        while (left <= right) {
            mid = left + (right - left) / 2;

            int prev = (mid + arr.length - 1) % arr.length;
            int next = (mid + 1) % arr.length;

            if (arr[prev] > arr[mid] && arr[next] > arr[mid]) {
                return arr[mid];
            } else if (arr[left] <= arr[mid]) {
                left = mid + 1;
            } else if (arr[mid] <= arr[right]) {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindMinInRotatedArray findMinInRotatedArray = new FindMinInRotatedArray();
        System.out.println(findMinInRotatedArray.findMin(new int[]{11, 12, 15, 18, 2, 5, 6, 8}));
    }
}
