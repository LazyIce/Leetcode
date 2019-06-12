public class _125_ValidPalindrome {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int low = 0, high = s.length() - 1;
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(s.charAt(low)))
                low++;
            while (low < high && !Character.isLetterOrDigit(s.charAt(high)))
                high--;
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
                return false;
            else {
                low++;
                high--;
            }
        }

        return true;
    }
}
