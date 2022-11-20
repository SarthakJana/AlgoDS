package search;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] arr, int l, int r) {
        int ls = -1, rs = -1;

        if (l <= r) {
            int m = l + (r - l) / 2;
            if ((m >= 1 && arr[m] != arr[m - 1]) && (m <= arr.length - 2 && arr[m] != arr[m + 1])) {
                return arr[m];
            }

            if (m >= 1 && arr[m] == arr[m - 1]) {
                ls = binarySearch(arr, l, m - 2);
            } else {
                ls = binarySearch(arr, l, m - 1);
            }

            if (arr[m] == arr[m + 1]) {
                rs = binarySearch(arr, m + 2, r);
            } else {
                rs = binarySearch(arr, m + 1, r);
            }

            if (ls != -1) return ls;
            if (rs != -1) return rs;
        }

        return -1;
    }

    public static void main(String[] args) {
        SingleElementInSortedArray se = new SingleElementInSortedArray();
        System.out.println(se.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
    }

}
