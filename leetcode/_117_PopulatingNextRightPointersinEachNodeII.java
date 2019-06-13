public class _117_PopulatingNextRightPointersinEachNodeII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public TreeLinkNode connect(TreeLinkNode root) {
        if (root == null)
            return null;

        TreeLinkNode head = null; // head of the next level
        TreeLinkNode prev = null; // the leading node of the next level
        TreeLinkNode cur = root;  // current node of current level
        TreeLinkNode res = cur;

        while (cur != null) {
            while (cur != null) {
                // left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                // right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            prev = null;
            head = null;
        }
        return res;
    }
}
