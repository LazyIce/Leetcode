public class _97_InterleavingString {
    /**
     * Dynamic Programming
     * time: O(m*n)
     * space: O(m*n)
     *
     e.g: s1 = "aa", s2 = "ab", s3 = "aaba"
          0  a  b
     0   1  1  0
     a   1  1  1
     a   1  0  1
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        // dp[i][j]: whether interleaving s2[0-i] and s1[0-j] can get s3[0, i]
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;

        // only use s2
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        // only use s1
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        // use both s1 and s2
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[s2.length()][s1.length()];
    }
}
