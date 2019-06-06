public class _82_RemoveDuplicatesfromSortedListII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;  // think about first node may be deleted
        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                int val = prev.next.val;
                // walk through all the same node
                while (prev.next != null && prev.next.val == val) {
                    prev.next = prev.next.next;
                }
            } else {
                prev = prev.next;
            }
        }

        return dummy.next;
    }
}
