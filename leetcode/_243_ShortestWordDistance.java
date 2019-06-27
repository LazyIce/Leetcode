public class _243_ShortestWordDistance {
    /**
     * Two Pointers
     * time: O(n)
     * space: O(1)
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            } else if (words[i].equals(word2)) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                res = Math.min(res, Math.abs(p1 - p2));
            }
        }
        return res;
    }
}
