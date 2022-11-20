package array;

import java.util.Arrays;

public class ReverserArray {

    public static void reverseArray(int[] arr) {
        int right = arr.length - 1;
        int left = 0;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println("Reversed array: " + Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 43, 43, 0, 4};
        reverseArray(arr);
    }
}
