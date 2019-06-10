import java.util.List;
import java.util.ArrayList;

public class _113_PathSumII {
    /**
     * Backtracking
     * time: O(n)
     * space: O(n)
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root, sum, new ArrayList<>());
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> list) {
        if (root == null)
            return;
        // our choice
        list.add(root.val);
        // our goal
        if (sum == root.val && root.left == null && root.right == null)
            res.add(new ArrayList<>(list));
        helper(res, root.left, sum - root.val, list);
        helper(res, root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }
}
