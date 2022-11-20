package search;

import stackdatastructure.StockSpanner;

public class FindFloorOFAnElement {
    public int findFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                result = arr[mid];
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindFloorOFAnElement findFloorOFAnElement = new FindFloorOFAnElement();
        System.out.println(findFloorOFAnElement.findFloor(new int[]{2, 3, 4, 6, 7, 9, 11}, 6));
    }
}
