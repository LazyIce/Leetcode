import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _103_BinaryTreeZigzagLevelOrderTravel {
    /**
     * time: O(n)
     * space: O(n)
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean odd = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (odd)
                    list.add(cur.val);
                else
                    list.add(0, cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
            res.add(list);
            odd = odd ? false : true;
        }

        return res;
    }
}
