public class _285_InorderSuccessorinBST {
    /**
     * Recursion
     * time: O(n)
     * space: O(h)
     */
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return inorderSuccessor1(root.right, p);
        } else {
            TreeNode temp = inorderSuccessor1(root.left, p);
            return temp != null ? temp : root;
        }
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}
