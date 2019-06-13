public class _132_PalindromePartitioningII {
    /**
     * Dynamic Programming
     * time: O(n^2)
     * space: O(n^2)
     */
    public int minCut(String s) {
        if (s == null || s.length() < 2)
            return 0;
        // whether substring s[j-i] is palindrome
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        // how many cuts for substring s[0-i]
        int[] cut = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }

        return cut[s.length() - 1];
    }
}
