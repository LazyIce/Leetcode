public class _510_InorderSuccessorinBSTII {
    /**
     * time: O(h)
     * space: O(1)
     */
    public Node inorderSuccessor(Node x) {
        if (x == null)
            return null;
        // find the successor in the children
        if (x.right != null) {
            x = x.right;
            while (x != null && x.left != null) {
                x = x.left;
            }
            return x;
        }
        // find the successor in the parents
        while (x != null) {
            if (x.parent == null)
                return null;
            if (x.parent.left == x)
                return x.parent;
            else
                x = x.parent;
        }

        return x;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
