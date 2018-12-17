/**
 * time: O(n)
 * space: O(n)
 */

import java.util.List;
import java.util.ArrayList;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            pathSum(root, sum, 0, res, new ArrayList<>());
        }
        return res;
    }

    private void pathSum(TreeNode node, int sum, int nodeSum, List<List<Integer>> res, List<Integer> list) {
        if (node == null) {
            return;
        }
        nodeSum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && nodeSum == sum) {
            res.add(new ArrayList<>(list));
        }
        pathSum(node.left, sum, nodeSum, res, list);
        pathSum(node.right, sum, nodeSum, res, list);
        list.remove(list.size() - 1);
    }
}
