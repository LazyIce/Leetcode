public class _53_MaximumSubarray {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(n)
     */
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        // dp[i]: max sum of subarray in nums[0, i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        // transition:  dp[i] = max{nums[i], dp[i-1]+nums[i]}
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    /**
     * Greedy
     * time: O(n)
     * space: O(1)
     */
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }

    // I don't like divide and conquer here. So complicated and time-consuming.
}
