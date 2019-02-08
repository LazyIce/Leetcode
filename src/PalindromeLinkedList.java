import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isPalindrome1(ListNode head) {
        if (head == null)
            return true;
        boolean res = true;
        Deque<Integer> list = new LinkedList<>();
        while (head != null) {
            list.offer(head.val);
            head = head.next;
        }
        while (list.size() > 1) {
            int low = list.pollFirst();
            int high = list.pollLast();
            if (low != high) {
                res = false;
                break;
            }
        }
        return res;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null)
            return true;
        ListNode prev = null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode prev2 = slow.next;
            slow.next = prev;
            prev = slow;
            slow = prev2;
        }
        if (fast != null) { // if it is odd,
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        if (slow != null || prev != null) {
            return false;
        }

        return true;
    }
}
