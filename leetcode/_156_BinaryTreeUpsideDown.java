public class _156_BinaryTreeUpsideDown {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeNode upsideDownBinaryTree1(TreeNode root) {
        if (root == null || root.left == null)
            return root;
        //root.left is newRoot everytime
        TreeNode newRoot = upsideDownBinaryTree1(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(1)
     */
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode temp = null;
        TreeNode next = null;
        while(cur != null){
            next = cur.left;
            cur.left = temp;
            temp = cur.right; //need temp to keep the previous right child

            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
