public class _213_HouseRobberII {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(1)
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int low, int high) {
        int exclude = 0, include = 0;
        for (int i = low; i <= high; i++) {
            int temp = exclude;   // keep the dp[i - 2]
            exclude = Math.max(exclude, include);   // update dp[i - 1] as dp[i - 2] for next dp[i+1]
            include = nums[i] + temp;
        }

        return Math.max(include, exclude);
    }
}
