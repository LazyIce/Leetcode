public class _198_HouseRobber {
    /**
     * Recursive
     * time: O(n)
     * space: O(n)
     */
    public int rob1(int[] nums) {
        return rob(nums, nums.length - 1);
    }
    private int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }

    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(n)
     */
    public int rob2(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            int val = nums[i];
            dp[i] = Math.max(dp[i - 1], dp[i-2] + val);
        }
        return dp[nums.length];
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int rob3(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
