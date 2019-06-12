public class _124_BinaryTreeMaximumPathSum {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    private int res;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        res = Math.max(res, left + right + root.val);
        // when go from bottom to up, we can only choose one side, i.e: left + root or right + root
        return Math.max(left, right) + root.val;
    }
}
