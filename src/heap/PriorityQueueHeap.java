package heap;

import java.util.PriorityQueue;

public class PriorityQueueHeap {
    static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public static void minHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
        }

        System.out.println("After heap");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(heap.stream().peek(System.out::print)+ " ");
        }
    }

    public static void main(String[] args) {
        PriorityQueueHeap.minHeap(new int[]{10, 7, 11, 5, 2, 13, 1, 45});
    }


}
