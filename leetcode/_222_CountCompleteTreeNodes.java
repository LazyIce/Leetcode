import java.util.Stack;

public class _222_CountCompleteTreeNodes {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res++;
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }

        return res;
    }

    /**
     * time: O(logn*logn)
     * space: TBD
     */
    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        // get the height of the tree
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)  // full binary tree
            return (1 << height) - 1;
        return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
}
