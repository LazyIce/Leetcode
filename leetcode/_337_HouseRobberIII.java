public class _337_HouseRobberIII {
    /**
     * Recursion
     * time: O(n)
     * space: O(n)
     */
    public int rob1(TreeNode root) {
        if (root == null)
            return 0;
        int val = 0;
        if (root.left != null) {
            val += rob1(root.left.left) + rob1(root.left.right);
        }
        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }
        return Math.max(val + root.val, rob1(root.left) + rob1(root.right));
    }

    /**
     * Dynamic Programming
     * time:
     * space:
     */
    public int rob2(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

}
