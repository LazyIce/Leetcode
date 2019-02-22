import java.util.LinkedList;
import java.util.Queue;

public class ClosetBinarySearchTreeValue {
    public int closestValue1(TreeNode root, double target) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        double min = Double.MAX_VALUE;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (min > Math.abs(cur.val - target)) {
                min = Math.abs(cur.val - target);
                res = cur.val;
            }
            if (cur.left != null)
                queue.offer(cur.left);
            if (cur.right != null)
                queue.offer(cur.right);
        }
        return res;
    }

    public int closestValue2(TreeNode root, double target) {
        int ret = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(ret - target)) {
                ret = root.val;
            }
            if (root.val > target) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return ret;
    }
}
