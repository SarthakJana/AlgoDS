package array;

import java.util.List;
import java.util.Stack;

public class LeadersInArray {

    public static List<Integer> getLeaders(int[] arr) {

        Stack<Integer> leaders = new Stack<>();

        leaders.push(arr[arr.length - 1]);


        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > leaders.peek()) {
                leaders.push(arr[i]);
            }
        }

        return leaders.stream().toList();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Leaders: " + getLeaders(arr));
    }
}
