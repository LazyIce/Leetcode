/**
 * time: O(n)
 * space: O(n)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            if (leftToRight) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollFirst();
                    list.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.pollLast();
                    list.add(cur.val);
                    if (cur.right != null) {
                        queue.add(0, cur.right);
                    }
                    if (cur.left != null) {
                        queue.add(0, cur.left);
                    }
                }
            }
            res.add(list);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
