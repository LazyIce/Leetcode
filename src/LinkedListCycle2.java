/**
 * time: O(n)
 * space: O(1)
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode walker = head;
        ListNode runner = head;
        boolean isCycle = false;
        while (walker != null && runner != null) {
            walker = walker.next;
            if (runner.next == null)
                return null;
            runner = runner.next.next;
            if (walker == runner) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            ListNode dummy = head;
            while(dummy != walker) {
                dummy = dummy.next;
                walker = walker.next;
            }
            return walker;
        }

        return null;
    }
}
