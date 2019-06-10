import java.util.Stack;

public class _114_FlattenBinaryTreetoLinkedList {
    /**
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    private TreeNode prev = null;

    public void flatten1(TreeNode root) {
        if (root == null)
            return;

        flatten1(root.left);
        flatten1(root.right);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     * Iterative
     * time: O(n)
     * space: O(n)
     */
    public void flatten2(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
