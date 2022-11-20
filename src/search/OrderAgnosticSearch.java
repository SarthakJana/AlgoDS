package search;

public class OrderAgnosticSearch {

    public static int OAgnosticSearch(int[] arr, int target) {
        boolean isAscending = true;

        if (arr[0] > arr[arr.length - 1])
            isAscending = false;

        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                if (isAscending) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (isAscending) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arrAsc = {10, 25, 34, 35, 49, 90};
        int[] arrDsc = {90, 49, 35, 34, 25, 10};
        System.out.println(OAgnosticSearch(arrDsc, 49));
    }
}
