public class _19_RemoveNthNodeFromEndofList {
    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);   // keep the result head
        dummy.next = head;
        // two pointers
        ListNode slow = dummy;
        ListNode fast = dummy;
        // let the fast pointer moves n + 1 steps first
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // when fast pointer moves to the end,
        // the next node of slow pointer is the n-th node from the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // remove the n-th node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }
}
