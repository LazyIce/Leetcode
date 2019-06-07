public class _91_DecodeWays {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(n)
     */
    public int numDecodings1(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] dp = new int[s.length() + 1];  // dp[n]: #ways for s[0-n]
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int one = s.charAt(i - 1) - '0';
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int numDecodings2(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        // c1 and c2 store ways of the last and the last of the last
        int c1 = 1;
        int c2 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c1 = 0;
            }
            // the number of last two characters in [10, 26]
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }
}
