package search;

public class CountOfElement {
    public int countElement(int[] arr, int target) {
        int firstIndex = findIndex(arr, target, true);
        int lastIndex = findIndex(arr, target, false);

        return lastIndex - firstIndex + 1;
    }

    private int findIndex(int[] arr, int target, boolean directionFlag) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int result = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid;
                if (directionFlag) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CountOfElement countOfElement = new CountOfElement();
        System.out.println(countOfElement.countElement(new int[]{2, 2, 2, 4, 5, 7, 9}, 2));
    }
}
