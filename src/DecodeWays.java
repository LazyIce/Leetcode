/**
 * time:
 * space:
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i-1) > '2' || s.charAt(i) == '0' && s.charAt(i-1) == '0')
                return 0;
            else if (i > 1 && s.charAt(i) == '0')
                dp[i] = dp[i-2];
            else if (s.charAt(i) == '0')
                dp[i] = 1;
            else if (Integer.parseInt(s.substring(i-1, i+1)) > 10 && Integer.parseInt(s.substring(i-1, i+1)) <= 26)
                dp[i] = dp[i-1] + 1;
            else
                dp[i] = dp[i-1];
        }
        return dp[s.length()-1];
    }
}
