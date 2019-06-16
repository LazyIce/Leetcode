public class _143_ReorderList {
    /**
     * Linked List
     * time: O(n)
     * space: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // find the middle node of the list
        ListNode temp = null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // split the list into two halves and reverse the second half of the lsit
        ListNode l1 = head;
        temp.next = null;
        ListNode l2 = reverse(slow);

        // merge the two halves
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != l2) {
            ListNode n1 = l1.next;
            ListNode n2 = l2.next;
            l1.next = l2;
            if (n1 == null)
                break;
            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }
    }
}
