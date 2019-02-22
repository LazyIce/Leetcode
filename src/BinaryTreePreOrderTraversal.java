/**
 * time: O(n)
 * space: O(n)
 */
import java.util.*;

public class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !st.isEmpty()) {
            if (cur == null)
                cur = st.pop();
            while (cur != null) {
                res.add(cur.val);
                if (cur.right != null)
                    st.push(cur.right);
                cur = cur.left;
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
