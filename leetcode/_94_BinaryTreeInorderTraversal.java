import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class _94_BinaryTreeInorderTraversal {
    /**
     * recursive
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }

    /**
     * iterative
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {   // important!
            // add left node
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // all left nodes added
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }

        return res;
    }
}
