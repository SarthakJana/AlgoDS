package array;

import java.util.Arrays;

public class MoveZerosToTheEnd {

    public static void moveZeros(int[] arr) {
        int zeroIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[zeroIndex];
                arr[zeroIndex] = temp;

                zeroIndex++;
            }
        }

        System.out.println("Result: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 0, 3, 0, 5, 6, 0, 0, 4};
        moveZeros(arr);
    }
}
