public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int low, int high) {
        if (low > high)
            return null;
        int max = Integer.MIN_VALUE, maxIndex = 0;
        for (int i = low; i <= high; i++) {
            maxIndex = nums[i] > max ? i : maxIndex;
            max = Math.max(nums[i], max);
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, low, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, high);
        return root;
    }
}
