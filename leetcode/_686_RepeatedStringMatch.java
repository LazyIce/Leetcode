public class _686_RepeatedStringMatch {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int repeatedStringMatch(String a, String b) {
        String as = a;
        for (int rep = 1; rep <= b.length() / a.length() + 2; rep++, as += a)
            if (as.indexOf(b) != -1) return rep;

        return -1;
    }
}
