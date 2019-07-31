import java.util.Queue;
import java.util.LinkedList;

public class _404_SumofLeftLeaves {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                res += root.left.val;
            else
                res += sumOfLeftLeaves1(root.left);
        }
        res += sumOfLeftLeaves1(root.right);

        return res;
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.left == null && cur.left.right == null)
                    res += cur.left.val;
                else
                    queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

        return res;
    }
}
