public class _234_PalindromeLinkedList {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        // use two pointers to find middle node
        // reverse the first part
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null && prev!= null) {
            if (slow.val != prev.val)
                return false;
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}
