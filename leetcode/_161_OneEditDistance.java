public class _161_OneEditDistance {
    /**
     * time: O(n)
     * space: O(1)
     * find the first different character, and compare the rest parts of two strings
     */
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            // s cannot equal to t
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}
