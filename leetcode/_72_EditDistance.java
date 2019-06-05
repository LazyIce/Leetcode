public class _72_EditDistance {
    /**
     * Dynamic Programming
     * time: O(m * n)
     * space: O(m * n)
     *
     dp[i][j]: distance of word1[0-i] to word2[0-j]
     transitions:
     1. last characters equal: dp[i][j] = dp[i - 1][j - 1]
     2. last characters don't equal:
       - insert: dp[i][j] = dp[i][j - 1] + 1;
       - replace: dp[i][j] = dp[i - 1][j - 1] + 1;
       - delete: dp[i][j] = dp[i - 1][j] + 1;
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
