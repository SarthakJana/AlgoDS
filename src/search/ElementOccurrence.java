package search;

public class ElementOccurrence {
    public void findElementIndex(int[] arr, int target) {
        int firstIndex = findIndex(arr, target, true);
        int lastIndex = findIndex(arr, target, false);

        System.out.println("First Occurrence: " + firstIndex);
        System.out.println("Last Occurrence: " + lastIndex);
    }

    private int findIndex(int[] arr, int target, boolean directionFlag) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex;
        int result = 0;

        while (leftIndex <= rightIndex) {
            midIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[midIndex] == target) {
                result = midIndex;
                if (directionFlag) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else if (target > arr[midIndex]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ElementOccurrence elementOccurrence = new ElementOccurrence();
        elementOccurrence.findElementIndex(new int[] {2, 2, 2, 4, 5, 7, 9}, 2);
    }
}
