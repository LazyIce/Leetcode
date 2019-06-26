import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class _236_LowestCommonAncestorofaBinaryTree {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);

        if (left != null && right != null)
            return root;
        else
            return left == null ? right : left;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.add(root);
        // use map to keep the child-parent pair
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = queue.poll();
            if (node != null) {
                parent.put(node.left, node);
                parent.put(node.right, node);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        // from bottom to top, find the parent
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
