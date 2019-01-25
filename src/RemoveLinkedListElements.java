/**
 * time: O(n)
 * space: O(1)
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode last = head;
        while (prev != null) {
            while (prev.next != null && prev.next.val != val) {
                prev = prev.next;
            }
            if (prev.next == null)
                break;
            last = prev.next;
            while (last.next != null && last.val == last.next.val) {
                last = last.next;
            }
            prev.next = last.next;
        }
        return dummy.next;
    }
}
