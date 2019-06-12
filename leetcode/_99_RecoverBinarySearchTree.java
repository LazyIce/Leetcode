import java.util.Stack;

public class _99_RecoverBinarySearchTree {
    /**
     * Inorder traversal: should be an increasing list
     * 1 2 3 4 5 6
     * if 1 5 3 4 2 6, test preNode.val > curNode.val
     * 5 > 3 wrong, first node (need to be switched) is preNode: 5
     * 4 > 2 wrong, second node (need to be switched) is curNode: 2
     */
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree1(TreeNode root) {
        if (root == null)
            return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        helper(root.right);
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public void recoverTree2(TreeNode root) {
        if (root == null) return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev != null && cur.val <= prev.val) {
                    if (first == null) first = prev;
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
