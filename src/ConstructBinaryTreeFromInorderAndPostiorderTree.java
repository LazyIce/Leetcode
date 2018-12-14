/**
 * time: O(n)
 * space: O(n)
 */
public class ConstructBinaryTreeFromInorderAndPostiorderTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        return helper(postorder.length - 1, 0, postorder.length - 1, postorder, inorder);
    }

    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode cur = new TreeNode(postorder[postEnd]);
        int i = inStart;
        while (i <= inEnd) {
            if (inorder[i] == postorder[postEnd])
                break;
            i++;
        }
        cur.left = helper(postEnd + i - 1 - inEnd, inStart, i - 1, postorder, inorder);
        cur.right = helper(postEnd - 1, i + 1, inEnd, postorder, inorder);
        return cur;
    }
}
