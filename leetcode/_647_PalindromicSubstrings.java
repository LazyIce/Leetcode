public class _647_PalindromicSubstrings {
    /**
     * Dynamic Programming
     * time: O(n^2)
     * space: O(n^2)
     */
    public int countSubstrings1(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j])
                    res++;
            }
        }
        return res;
    }

    /**
     * Recursion
     * time: O(n^2)
     * space: O(1)
     */
    public int countSubstrings2(String s) {
        int res = 0;
        for(int i = 0; i <s.length(); i++){
            res += extractPalindrome(s, i, i); //odd length
            res += extractPalindrome(s, i, i+1); //even length
        }
        return res;
    }

    public int extractPalindrome(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
            count++;
        }

        return count;
    }
}
