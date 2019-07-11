public class _312_BurstBalloons {
    /**
     * Dynamic Programming + DFS
     * time: O(n^3)
     * space: O(n^2)
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = balloons[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }
        // dp[i][j]: the coins for bursting balloon i to j
        int[][] dp = new int[n + 2][n + 2];
        return helper(balloons, dp, 1, n);
    }

    public int helper(int[] balloons, int[][] dp, int i, int j) {
        if (i > j)
            return 0;
        if (dp[i][j] > 0)
            return dp[i][j];
        for (int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], helper(balloons, dp, i, k - 1) + balloons[i - 1] * balloons[k] * balloons[j + 1] + helper(balloons, dp, k + 1, j));
        }

        return dp[i][j];
    }
}
