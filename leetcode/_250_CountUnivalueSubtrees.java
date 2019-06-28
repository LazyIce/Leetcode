public class _250_CountUnivalueSubtrees {
    /**
     * time: O(n)
     * space: O(n)
     */
    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnivalue(root);
        return count;
    }

    public boolean isUnivalue(TreeNode node){
        if(node == null)
            return true;

        if(isUnivalue(node.left) & isUnivalue(node.right)) {
            if(node.left != null && node.left.val != node.val)
                return false;
            if(node.right != null && node.right.val != node.val)
                return false;

            count += 1;
            return true;
        }

        return false;
    }
}
