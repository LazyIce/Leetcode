public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {//"**ho"
                dp[0][i + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char chars = s.charAt(i - 1);
                char charp = p.charAt(j - 1);
                if (charp == chars || charp == '?') {
                    dp[i][j] = dp[i - 1][ j - 1];
                } else if (charp == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];//不匹配，匹配当前一个，匹配之前多个
                }
            }
        }
        return dp[m][n];
    }
}
