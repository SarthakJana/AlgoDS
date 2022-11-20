package array;

public class ArrayIsSorted {
    public static boolean isSorted(int[] arr) {
         boolean arraySorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                arraySorted = false;
            }
        }

        return arraySorted;
    }

    public static void main(String[] args) {
        int[] arr = {5, 12, 30, 30, 50, 10};

        System.out.println("Is array sorted: " + isSorted(arr));
    }
}
