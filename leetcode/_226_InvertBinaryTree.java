import java.util.Queue;
import java.util.LinkedList;

public class _226_InvertBinaryTree {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree1(right);
        root.right = invertTree1(left);
        return root;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }

        return root;
    }
}
