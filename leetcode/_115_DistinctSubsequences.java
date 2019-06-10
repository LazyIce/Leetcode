public class _115_DistinctSubsequences {
    /**
     * Dynamic Programming
     * time: O(m*n)
     * space: O(m*n)
     */
    public int numDistinct(String s, String t) {
        if (s == null || s.length() == 0)
            return 0;

        int[][] dp = new int[s.length() + 1][t.length() + 1];   // dp[i][j]: #distinct subsequences in s[0-i] for t[0-j]
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];   // dp[i-1][j]: duplicate last character
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
