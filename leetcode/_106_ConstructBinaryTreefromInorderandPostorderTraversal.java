import java.util.Stack;

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }

    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postEnd < 0 || postEnd >= postorder.length || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, postorder, inorder);
        root.right = helper(postEnd - 1, inIndex + 1, inEnd, postorder, inorder);
        return root;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        int ip = inorder.length - 1;
        int pp = postorder.length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.push(root);
        pp--;

        while (pp >= 0) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode currTop = stack.peek();
                currTop.right = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp--;
        }

        return root;
    }
}
