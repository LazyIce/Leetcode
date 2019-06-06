public class _76_MinimumSlidingSubstring {
    /**
     * Sliding Window
     * time: O(n)
     * space: O(1)
     */
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        // keep the characters in t
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        // sliding window
        int start = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        // move right pointer
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0)
                total--;
            // find all the characters in t
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    start = j;
                }
                // move left pointer
                if (++cnt[s.charAt(j++)] > 0)
                    total++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
