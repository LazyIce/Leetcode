public class _92_ReverseLinkedListII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        for (int i = 1; i < m; i++) {
            cur = cur.next;
            prev = prev.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;   // keep the cur.next
            cur.next = temp.next;   // update cur
            temp.next = prev.next;   // update cur.next
            prev.next = temp;   // update prev
        }

        return dummy.next;
    }
}
