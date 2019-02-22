import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        int min = 0, max = 0;
        queue.offer(root);
        col.offer(0);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int colId = col.poll();
            if (!map.containsKey(colId)) {
                map.put(colId, new ArrayList<Integer>());
            }
            map.get(colId).add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                col.offer(colId-1);
                min = Math.min(min, colId-1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                col.offer(colId+1);
                max = Math.max(max, colId+1);
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.println(map.get(i));
            res.add(map.get(i));
        }
        return res;
    }
}
