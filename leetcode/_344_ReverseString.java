public class _344_ReverseString {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1)
            return;
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

        return;
    }
}
