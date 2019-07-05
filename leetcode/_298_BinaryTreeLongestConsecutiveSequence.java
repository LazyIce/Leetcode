import java.util.LinkedList;
import java.util.Queue;

public class _298_BinaryTreeLongestConsecutiveSequence {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    private int res = 0;
    public int longestConsecutive1(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, 0, root.val);
        return res;
    }

    public void helper(TreeNode root, int max, int target) {
        if (root == null)
            return;
        if (root.val == target) {
            max++;
        } else
            max = 1;
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }

    /**
     * Iteration
     * time: O(n)
     * space: O(n)
     */
    public int longestConsecutive2(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(root);
        q2.add(1);
        int max = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int count = q2.poll();
                if(cur.left != null) {
                    q.add(cur.left);
                    if(cur.left.val == cur.val+1) {
                        q2.add(count + 1);
                        max = count + 1 > max ? count + 1 : max;
                    }
                    else
                        q2.add(1);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                    if(cur.right.val == cur.val+1) {
                        q2.add(count + 1);
                        max = count + 1 > max ? count + 1 : max;
                    }
                    else
                        q2.add(1);
                }
            }
        }
        return max;
    }
}
