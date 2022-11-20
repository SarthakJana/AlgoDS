package array;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicateElement(int[] arr) {
        int res = 1;

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res++] = arr[i];
            }
        }

        System.out.println("Distinctarray: " + Arrays.toString(arr));

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 4, 5};

        removeDuplicateElement(arr);
    }
}
