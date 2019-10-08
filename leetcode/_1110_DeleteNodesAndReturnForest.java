import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class _1110_DeleteNodesAndReturnForest {
    /**
     * time: O(N)
     * space: O(h + m)
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        if (to_delete == null || to_delete.length == 0) {
            res.add(root);
            return res;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }

        if (!set.contains(root.val)) {
            res.add(root);
        }
        dfs(root, set, res);
        return res;
    }

    public TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, set, res);
        node.right = dfs(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }
        return node;
    }
}
