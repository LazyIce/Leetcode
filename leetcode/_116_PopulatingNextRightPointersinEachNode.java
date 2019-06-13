public class _116_PopulatingNextRightPointersinEachNode {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeLinkNode connect1(TreeLinkNode root) {
        if (root == null)
            return null;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect1(root.left);
        connect1(root.right);

        return root;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public TreeLinkNode connect2(TreeLinkNode root) {
        if (root == null)
            return null;
        // start is used to traversal left node in depth: start = start.left
        // cur is used to traversal cur node in breadth: cur = cur.next;
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.next != null && cur.right != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
        return root;
    }
}
