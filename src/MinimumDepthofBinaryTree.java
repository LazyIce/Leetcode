import java.util.Stack;

public class MinimumDepthofBinaryTree {
    //recursion
    public int minDepth1(TreeNode root) {
        if(root == null )
            return 0;
        if(root.left == null)
            return 1 + minDepth1(root.right);
        if(root.right == null)
            return 1 + minDepth1(root.left);
        return 1 + Math.min(minDepth1(root.left), minDepth1(root.right));
    }

    //iteratively
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 1;
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        nodes.push(root);
        depths.push(depth);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            depth = depths.pop();
            if(node.left == null && node.right == null) {
                min = Math.min(min, depth);
            }
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth + 1);

            }
            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth + 1);
            }
        }
        return min;
    }
}
