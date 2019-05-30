public class _44_WildcardMatching {
    /**
     * O(m * n)
     * O(1)
     */
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int match = 0;
        int star = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {   // single character matches
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {   // *
                star = j;   // save temp position for '*'
                match = i;   // keep i
                j++;   // move j
            } else if (star != -1) {   // s[i] != p[j], with '*' ahead
                j = star + 1;
                match++;
                i = match;
            } else
                return false;
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
