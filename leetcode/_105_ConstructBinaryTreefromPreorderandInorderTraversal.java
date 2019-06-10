import java.util.Stack;

public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
    /**
     * Preorder traversal implies that preorder[0] is the root node.
     * In inorder traversal, we can find preorder[0], say it's inorder[5].
     * So, inorder[5] is root
     * inorder[0] - inorder[4] is on the left side, inorder[6] to the end is on the right side.
     * Recursively doing this on subarrays
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);

        return root;
    }

    /**
     * Iterative
     * time: O(n)
     * space: O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        int ip = 0;
        int pp = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(preorder[pp]);
        stack.push(root);
        pp++;

        while (pp < preorder.length) {
            while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                prev = stack.pop();
                ip++;
            }
            TreeNode newNode = new TreeNode(preorder[pp]);
            if (prev != null) {
                prev.right = newNode;
            } else if (!stack.isEmpty()) {
                TreeNode curTop = stack.peek();
                curTop.left = newNode;
            }
            stack.push(newNode);
            prev = null;
            pp++;
        }

        return root;
    }
}
