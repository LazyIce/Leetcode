import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    /**
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
     * time: O(n)
     * space: O(n)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> sk = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !sk.isEmpty()) {
            while (cur != null) {
                sk.push(cur);
                cur = cur.left;
            }
            cur = sk.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
