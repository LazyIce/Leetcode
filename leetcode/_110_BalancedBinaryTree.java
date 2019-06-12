public class _110_BalancedBinaryTree {
    /**
     * time: O(n)
     * space: O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return helper(root) != -1;
    }

    //  on each level, depth++
    // if we find that it's not balanced-height, return -1
    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1)
            return -1;
        return Math.max(l, r) + 1;
    }
}
