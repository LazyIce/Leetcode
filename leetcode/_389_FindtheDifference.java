public class _389_FindtheDifference {
    /**
     * Bit Manipulation
     * time: O(n)
     * space: O(1)
     */
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res ^= (int)c;
        }
        for (char c : t.toCharArray()) {
            res ^= (int)c;
        }

        return (char)res;
    }
}
