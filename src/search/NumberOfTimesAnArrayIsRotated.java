package search;

public class NumberOfTimesAnArrayIsRotated {

    public static int solution(int[] arr) {
        int minIndex = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;
        int left = 0, right = end;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]) {
               return mid;
            } else if(arr[start] <= arr[mid]) {
                left = mid + 1;
            } else if(arr[end] >= arr[mid]) {
                right = mid - 1;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{15, 18, 2, 5, 6, 8, 11, 12}));
    }

}
