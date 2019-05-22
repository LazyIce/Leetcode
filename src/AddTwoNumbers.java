public class AddTwoNumbers {
    /**
     * time: O(N)
     * space: O(N)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while (l1 != null || l2 != null) {
            int n1 = 0, n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            temp = temp % 10;
            pointer.next = new ListNode(temp);
            pointer = pointer.next;
        }
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return result.next;
    }
}
