public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        if (p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        if (root.val == p.val || root.val == q.val)
            return root;
        if (p.val < root.val && root.val < q.val)
            return root;
        if (p.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        if (q.val < root.val)
            return lowestCommonAncestor(root.left, p,q);
        return null;
    }
}
