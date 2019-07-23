public class _392_IsSubsequence {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
