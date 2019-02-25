public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {

        int leftDepth = leftDepth(root);//depth of leftmost node in the root tree
        int rightDepth = rightDepth(root);//depth of rightmost node in the root tree

        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else
            return 1+countNodes(root.left) + countNodes(root.right);

    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
}
