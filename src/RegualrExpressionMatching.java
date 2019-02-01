public class RegualrExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 2; i <= len2; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= len1; i ++) {
            for (int j = 1; j <= len2; j++) {
                char charP = p.charAt(j - 1);
                char charS = s.charAt(i - 1);
                if (charP == '.' || charP == charS) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (charP == '*') {
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == charS) {//".*"
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];//＊匹配之前的 ".", 或者不用，或者dp[i][j - 2]
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
