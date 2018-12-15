/**
 * time: O(n)
 * space: O(n)
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (right == -1 || left == -1 || Math.abs(left-right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
