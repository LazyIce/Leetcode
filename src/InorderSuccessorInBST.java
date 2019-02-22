public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val > p.val) {
            TreeNode left = inorderSuccessor1(root.left, p);
            return  left == null ? root : left;
        } else {
            return inorderSuccessor1(root.right, p);
        }
    }

    public TreeNode inorderSucessor2(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
