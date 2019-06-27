public class _245_ShortestWordDistanceIII {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int res = words.length;
        // word1 and word2 are the same
        if (word1.equals(word2)) {
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    p1 = p2;
                    p2 = i;
                    if (p1 != -1 && p2 != -1)
                        res = Math.min(res, Math.abs(p2 - p1));
                }
            }
        } else {  // word1 and word2 are different
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    p1 = i;
                }
                if (words[i].equals(word2)) {
                    p2 = i;
                }
                if (p1 != - 1 && p2 != -1) {
                    res = Math.min(res, Math.abs(p2 - p1));
                }
            }
        }

        return res;
    }
}
