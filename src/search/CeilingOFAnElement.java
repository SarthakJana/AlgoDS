package search;

public class CeilingOFAnElement {
    public int findCeiling(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        int result = 0;


        while (left <= right) {
            mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (target < arr[mid]) {
                result = arr[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CeilingOFAnElement ceilingOFAnElement = new CeilingOFAnElement();
        System.out.println(ceilingOFAnElement.findCeiling(new int[]{2, 4, 6, 8, 10, 11}, 8));
    }
}
