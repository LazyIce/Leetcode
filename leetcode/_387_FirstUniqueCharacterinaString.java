public class _387_FirstUniqueCharacterinaString {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
