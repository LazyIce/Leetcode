public class UniquePath {
    /**
     * time: O(m*n)
     * space: O(m*n)
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;

        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * time: O(m*n)
     * space: O(n)
     */
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }

    /**
     * time: O(m)
     * space: O(1)
     */
    public int uniquePaths3(int m, int n) {
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (count - k + i ) / i;
        }
        return (int)res;
    }
}
