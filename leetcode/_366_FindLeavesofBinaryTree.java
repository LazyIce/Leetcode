import java.util.List;
import java.util.ArrayList;

public class _366_FindLeavesofBinaryTree {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    public int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null)
            return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
