public class _62_UniquePaths {
    /**
     * Dynamic Programming
     * time: O(m*n)
     * space: O(m*n)
     */
    public int uniquePaths1(int m, int n) {
        if (m <= 1 || n <= 1)
            return 1;
        int[][] dp = new int[m][n];   // dp[m][n]: #paths to end from point[m][n]
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    /**
     * Dynamic Programming
     * time: O(m*n)
     * space: O(n)
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * Combination(Count, k)
     n - 1 steps to right, m - 1 steps to down
     * time : O(m)
     * space : O(1)
     */
    public int uniquePaths3(int m, int n) {
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (count - k + i) / i;
        }
        return (int)res;
    }
}
