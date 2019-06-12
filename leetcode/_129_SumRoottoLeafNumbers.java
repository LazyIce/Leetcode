public class _129_SumRoottoLeafNumbers {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, 0);
    }

    // use num to save previous sum
    public int helper(TreeNode root, int num) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return num * 10 + root.val;
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
