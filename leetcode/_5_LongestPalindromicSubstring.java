public class _5_LongestPalindromicSubstring {
    /**
     * time complexity: O(n^2)
     * sapce complexity: O(n^2)
     *
     dp[i][j]:  whether s[i-j] is a palindrome

     if j - i <= 2, dp[i][j] = true if s.charAt(i) == s.charAt(j)
     if j- i > 2, dp[i][j] = true if s.charAt(i) == s.charAt(j) && dp[i+1][j-1]
     */
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;

        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i+1][j-1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }
}
