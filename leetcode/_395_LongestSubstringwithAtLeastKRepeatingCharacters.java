public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {
    /**
     * Sliding Window, Two pointers
     * time：O(n)
     * space: O(1)
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        char[] chs = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i++)
            chs[s.charAt(i) - 'a']++;

        // return the length of string if this string is a valid string
        boolean flag = true;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < k && chs[i] > 0)
                flag = false;
        }
        if (flag == true)
            return s.length();

        // otherwise we use all the infrequent elements as splits
        int res = 0;
        int start = 0, cur = 0;
        while (cur < s.length()) {
            if (chs[s.charAt(cur) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        res = Math.max(res, longestSubstring(s.substring(start), k));

        return res;
    }
}
