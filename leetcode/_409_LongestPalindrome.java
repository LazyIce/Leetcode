import java.util.Set;
import java.util.HashSet;

public class _409_LongestPalindrome {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int longestPalindrome1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }
        if (set.size() != 0)
            return count * 2 + 1;
        return count * 2;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] count = new char[256];
        int res = 0;
        boolean bool = false;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
                res++;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) bool = true;
        }
        if (bool)
            return res * 2 + 1;
        return res * 2;
    }
}
