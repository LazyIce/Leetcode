public class _24_SwapNodesinPairs {
    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;   // keep the result
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next.next;   // save next start
            prev.next = cur.next;   // update next node of prev
            cur.next.next = cur;   // update next node of even node
            cur.next = next;   // update next node of odd node
            prev = cur;   // update prev
            cur = cur.next;   // update cur
        }

        return dummy.next;
    }

    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        head.next = swapPairs2(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
