public class _375_GuessNumberHigherorLowerII {
    /**
     * MinMax Problem
     * Dynamic Programming
     * time: O(n^3)
     * space: O(n^2)
     */
    public int getMoneyAmount(int n) {
        // dp[i][j]: the cost of finding target in [i, j]
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }

        return dp[1][n];
    }
}
