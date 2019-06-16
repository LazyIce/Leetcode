import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class _144_BinaryTreePreorderTraversal {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur == null)
                cur = stack.pop();
            res.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            cur = cur.left;
        }

        return res;
    }
}
