public class _235_LowestCommonAncestorofaBinarySearchTree {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor1(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor1(root.right, p, q);
        else
            return root;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while (true) {
            if (cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            } else if (cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            } else {
                break;
            }
        }
        return cur;
    }
}
