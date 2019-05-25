public class _2_AddTwoNumbers {
    /**
     * time complexity: O(n)
     * sapce complexity: O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);   // keep the head of result
        ListNode pointer = result;   // link each digit

        // traverse two linked lists
        // consider the length of two linked lists can be different
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

        // add the last carry if it exists
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return result.next;
    }
}
