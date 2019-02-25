import java.util.Stack;

public class MaximumDepthofBinaryTree {
    //recursion
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null)
            return 1 + maxDepth1(root.right);
        else if (root.right == null)
            return 1 + maxDepth1(root.left);
        else
            return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    //iteratively
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        int max = 1;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.push(root);
        depths.push(depth);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            depth = depths.pop();
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth + 1);
                max = Math.max(max, depth + 1);
            }
            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth + 1);
                max = Math.max(max, depth + 1);
            }
        }
        return max;
    }
}
