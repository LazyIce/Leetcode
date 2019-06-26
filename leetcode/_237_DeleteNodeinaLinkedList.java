public class _237_DeleteNodeinaLinkedList {
    /**
     * time: O(n)
     * space: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
