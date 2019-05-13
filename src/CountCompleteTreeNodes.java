import java.util.ArrayDeque;
import java.util.Deque;

public class CountCompleteTreeNodes {
    private int res = 0;

    // recursion
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        res = countNodes1(root.left) + countNodes1(root.right) + 1;
        return res;
    }

    // iteration BFS
    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res++;
            if (curNode.left != null)
                stack.push(curNode.left);
            if (curNode.right != null)
                stack.push(curNode.right);
        }
        return res;
    }

    // Iteration DFS
    public int countNodes3(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
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
}
