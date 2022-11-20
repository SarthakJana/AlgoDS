package search;

public class BinarySearch {
    public int search(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;

        while (leftIndex <= rightIndex) {
            midIndex = leftIndex + (rightIndex - leftIndex)/2;

            if (arr[midIndex] == target) {
                return midIndex;
            } else if (target > arr[midIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = rightIndex - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[] {-1, 0, 3, 5, 9, 12}, 13));
    }
}

