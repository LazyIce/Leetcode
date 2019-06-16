public class _147_InsertionSortList {
    /**
     * time: O(n^2)
     * space: O(1)
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            // if sorted, continue
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {  // if not sorted, reverse
                next = cur.next;
                cur.next = next.next;
                // start from head until cur
                prev = dummy;
                while (prev.next.val <= next.val) {
                    prev = prev.next;
                }
                // swap
                next.next = prev.next;
                prev.next = next;
            }
        }

        return dummy.next;
    }
}
