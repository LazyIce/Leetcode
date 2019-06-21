public class _206_ReverseLinkedList {
    /**
     * Recursion
     * time: O(n)
     * space: O(1)
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
