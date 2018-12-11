/**
 * time: O(n)
 * space: O(n)
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        return helper(0, 0, preorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[preStart]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == preorder[preStart])
                break;
            i++;
        }
        cur.left = helper(preStart+1, inStart, i-1, preorder, inorder);
        cur.right = helper(preStart + i - inStart + 1, i+1, inEnd, preorder, inorder);
        return cur;
    }
}
