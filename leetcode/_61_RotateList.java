public class _61_RotateList {
    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        // count the length of list and circle it.
        int len = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            dummy = dummy.next;
            len++;
        }
        dummy.next = head;

        // get the node of new head
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;

        return res;
    }
}
