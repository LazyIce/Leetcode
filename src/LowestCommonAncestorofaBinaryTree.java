public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ||p == null || q == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if (left != null && right != null)
            return root;//两边都有说明,p和q分布在两边，LCA只能是root
        if (left != null) {
            return left;
        } else{
            return right;
        }
    }
}
