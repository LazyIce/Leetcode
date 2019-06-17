public class _160_IntersectionofTwoLinkedLists {
    /**
     * time: O(n)
     * space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        int lenA = 0;
        int lenB = 0;

        while (dummyA != null) {
            dummyA = dummyA.next;
            lenA++;
        }

        while (dummyB != null) {
            dummyB = dummyB.next;
            lenB++;
        }

        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB) {
            while (diff-- > 0)
                headA = headA.next;
        } else {
            while (diff-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
