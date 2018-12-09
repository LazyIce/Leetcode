/**
 * time: O(n)
 * space: worst: O(n) best: O(logn)
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int result = 0;
        return helper(root, result);
    }

    public int helper(TreeNode node, int result) {
        if (node == null) {
            return result;
        } else {
            result += 1;
        }
        if (node.left == null && node.right == null) {
            return result;
        } else {
            int result1 = helper(node.left, result);
            int result2 = helper(node.right, result);
            return Math.max(result1, result2);
        }
    }
}
