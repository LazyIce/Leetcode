import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class _107_BinaryTreeLevelOrderTraversalII {
    /**
     * Iterative
     * time: O(n)
     * space: O(n)
     */
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                list.add(cur.val);
            }
            res.add(0, list);
        }

        return res;
    }

    /**
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(res, root, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null)
            return;
        if (level >= res.size())
            res.add(0, new ArrayList<>());
        res.get(res.size() - level - 1).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}
