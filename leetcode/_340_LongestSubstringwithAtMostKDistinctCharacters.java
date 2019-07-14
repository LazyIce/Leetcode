public class _340_LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Sliding Window
     * time: O(n)
     * space: O(1)
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            while (num > k && i < s.length()) {   // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) {
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }

        return res;
    }
}
