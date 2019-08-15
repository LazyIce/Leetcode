public class _680_ValidPalindromeII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean validPalindrome(String s) {
        int left = -1, right = s.length();
        while (++left < --right)
            if (s.charAt(left) != s.charAt(right))
                return isPalindromic(s, left, right + 1) || isPalindromic(s, left - 1, right);
        return true;
    }

    public boolean isPalindromic(String s, int left, int right) {
        while (++left < --right)
            if (s.charAt(left) != s.charAt(right))
                return false;
        return true;
    }
}
