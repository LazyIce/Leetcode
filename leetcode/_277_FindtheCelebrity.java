public class _277_FindtheCelebrity {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int findCelebrity(int n) {
        if (n < 2)
            return -1;

        int candidate = 0;
        // If candidate knows i, then switch candidate.
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i))
                candidate = i;
        }
        // Check whether the candidate is real.
        for (int i = 0; i < n; i++) {
            if (candidate != i && ((knows(candidate, i) || !knows(i, candidate)))) {
                return -1;
            }
        }
        return candidate;
    }

    public boolean knows(int i, int j) {
        return true;
    }
}
