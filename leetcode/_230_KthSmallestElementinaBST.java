import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class _230_KthSmallestElementinaBST {
    /**
     * Inorder Traversal, Iteration
     * time: O(n)
     * space: O(n)
     */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nums = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            nums.add(cur.val);
            cur = cur.right;
        }

        return nums.get(k - 1);
    }

    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    private int count = 0;
    private int res = 0;
    public int kthSmallest2(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root) {
        if (root == null)
            return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
