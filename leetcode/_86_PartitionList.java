public class _86_PartitionList {
    /**
     * time: O(n)
     * space: O(n)
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;

        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                large.next = temp;
                large = large.next;
            }
            head = head.next;
        }

        small.next = largeHead.next;
        return smallHead.next;
    }
}
