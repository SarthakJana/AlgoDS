package array;

import java.util.Arrays;

public class LeftRotateAnArrayByOnePlace {

    public static void leftRotate(int[] arr) {
        int temp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;

        System.out.println("Rotated array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 5};
        leftRotate(arr);
    }
}
