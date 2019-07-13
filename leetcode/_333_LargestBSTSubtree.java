public class _333_LargestBSTSubtree {
    /**
     * time: O(n)
     * space: O(n)
     */
    private int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return res;
    }

    public SearchNode helper(TreeNode root) {
        if (root == null) {
            return new SearchNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        SearchNode left = helper(root.left);
        SearchNode right = helper(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new SearchNode(-1, 0, 0);
        }
        int size = left.size + right.size + 1;
        res = Math.max(size, res);
        return new SearchNode(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }

    class SearchNode {
        int size;
        int lower;
        int upper;

        SearchNode(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
