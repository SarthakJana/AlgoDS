package sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left + right / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, right, mid);
        }
    }

    private void merge(int[] arr, int left, int right, int mid) {
        int nl = mid - left + 1;
        int nr = right - mid;
        int l, r;
        l = r = 0;

        int[] leftArr = new int[nl + 1];
        int[] rightArr = new int[nr + 1];

        for (int i = 0; i < nl; i++) {
            leftArr[i] = arr[left + i];
        }

        for (int i = 0; i < nr; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        leftArr[nl] = Integer.MAX_VALUE;
        rightArr[nr] = Integer.MAX_VALUE;

        for (int k = 0; k <= right; k++) {
            if (leftArr[l] < rightArr[r]) {
                arr[k] = leftArr[l++];
            } else {
                arr[k] = rightArr[r++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,5, 3, 1, 67};

        System.out.println(Arrays.toString(arr));
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
