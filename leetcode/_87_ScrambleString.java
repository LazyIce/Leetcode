public class _87_ScrambleString {
    /**
     * Recursion
     * time: O(n!)
     * space: O(n)
     */
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;

        if (s1.equals(s2))
            return true;

        int[] letters = new int[26];
        int len = s1.length();
        // s1 and s2 have different charaters
        for (int i = 0; i < len; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0)
                return false;
        }
        // s1 and s2 have the same charaters
        for (int i = 1; i < len; i++) {
            // no switch
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            // switch left part and right part
            if (isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }
}
