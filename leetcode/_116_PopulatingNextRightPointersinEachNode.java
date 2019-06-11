public class _116_PopulatingNextRightPointersinEachNode {
    /**
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    public Node connect1(Node root) {
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
     * Iterative
     * time: O(n)
     * space: O(1)
     */
    public Node connect2(Node root) {
        if (root == null)
            return null;
        // start is used to traversal left node in depth: start = start.left
        // cur is used to traversal cur node in breadth: cur = cur.next;
        Node start = root;
        while (start != null) {
            Node cur = start;
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
