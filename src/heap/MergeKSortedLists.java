package heap;


import java.util.PriorityQueue;


//This should be implemented using Divide-N-Conquer
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        if (lists.length == 0) {
            return null;
        }

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                minHeap.add(temp.val);
                temp = temp.next;
            }
        }

        if (!minHeap.isEmpty()) {
            ListNode head = new ListNode(minHeap.poll(), null);
            ListNode t = head;

            //O(nlog(n))
            while (!minHeap.isEmpty()) {
                ListNode node = new ListNode(minHeap.poll(), null);
                t.next = node;
                t = node;
            }

            return head;
        } else {
            return null;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
