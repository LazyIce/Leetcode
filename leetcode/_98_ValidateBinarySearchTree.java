import java.util.Stack;

public class _98_ValidateBinarySearchTree {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, null, null);
    }

    // keep the track of min and max!
    public boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (min != null && root.val <= min)
            return false;
        if (max != null && root.val >= max)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        // Inorder Traversal
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
