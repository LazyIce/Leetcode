public class _242_ValidAnagram {
    /**
     * time: O(n)
     * sapce: O(n)
     */
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length())
            return false;
        int[] letters = new int[256];
        for(char c : s.toCharArray())
            letters[c]++;
        for(char c : t.toCharArray())
            if(letters[c]-- == 0)
                return false;
        return true;
    }
}
