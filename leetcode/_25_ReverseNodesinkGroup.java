public class _25_ReverseNodesinkGroup {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int count = 0;
        ListNode cur = head;
        // find the k+1 node
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        // k+1 node is found
        if (count == k) {
            cur = reverseKGroup1(cur, k);   // reverse the list with k+1 node as head
            // reverse the current k-group
            while (count-- > 0) {
                ListNode temp = head.next;   // keep the next node
                head.next = cur;   // head points to the reversed part
                cur = head;   // update the head of reversed part
                head = temp;   // update the head
            }
            head = cur;
        }
        return head;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     *
     Dummy -> 1 -> 2 -> 3 -> 4 -> 5
     prev        cur          next
                  start

     Dummy -> 2 -> 3 -> 1 -> 4 -> 5
     prev         cur  next  start

     Dummy -> 3 -> 2 -> 1 -> 4 -> 5
     prev        cur         start
                   next
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;

        while (true)  {
            ListNode prev = start, cur, next = prev;
            start = prev.next;
            // get the k-th node or the last node
            for(int i = 0; i < k && next != null; i++)
                next = next.next;
            // length of linked list < k
            if(next == null)
                break;
            // reverse the current group
            for(int i = 0; i < k-1; i++) {
                cur = prev.next;   // get the head of direct part
                prev.next = cur.next;   // update the head of direct part
                cur.next = next.next;   // head of direct part points to reversed oart
                next.next = cur;   // update the head of reversed part
            }
        }

        return dummy.next;
    }
}
