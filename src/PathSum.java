/**
 * time: O(n)
 * space: O(n)
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return isSum(root, sum);
    }

    private boolean isSum(TreeNode root, int sum) {
        return root != null && (root.val == sum && root.left == null && root.right == null || isSum(root.left, sum - root.val) || isSum(root.right, sum - root.val));
    }
}
