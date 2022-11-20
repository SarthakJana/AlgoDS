package search;

public class FindElementInSortedRotatedArray {

    public static int solution(int[] arr, int target) {
        int start= 0, end = arr.length - 1;
        int minIndex = Integer.MAX_VALUE;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                minIndex = mid;
                break;
            } else if(arr[start] <= arr[mid]){
                start= mid + 1;
            } else if(arr[end] >= arr[mid]) {
                end = mid - 1;
            }
        }

        int leftArrSearch = binarySearch(arr, 0, minIndex - 1, target);
        int rightArrSearch = binarySearch(arr, minIndex + 1, arr.length - 1, target);

        if(leftArrSearch != -1) {
            return  leftArrSearch;
        } else if(rightArrSearch  != -1) {
            return  rightArrSearch;
        }

        return -1;

    }

    public static int binarySearch(int[] arr, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return arr[mid];
            } else if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{15, 18, 2, 5, 6, 8, 11, 12}, 8 ));
    }

}
