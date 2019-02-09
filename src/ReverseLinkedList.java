public class ReverseLinkedList {
    /**
     * Iterative
     * time: O(n)
     * space: O(1)
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;   // save the next node
            cur.next = prev;   // reverse the list
            prev = cur; // advance the prev
            cur = next; // advance the cur
        }
        return prev; // return the new head
    }

    /**
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode reversedListHead = reverseList2(head.next);  // down down down
        head.next.next = head; // add me
        head.next = null; // add me
        return reversedListHead; // top
    }

}
