public class _52_NQueensII {
    int res = 0;

    public int totalNQueens(int n) {
        /**
         * time: O(n^n)
         * space: O(n)
         */
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];   // leftdiag
        boolean[] d2 = new boolean[2 * n];   // rightdiag
        helper(0, cols, d1, d2, n);
        return res;
    }

    // Backtracking
    public void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        // our goal
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            // our constraints
            if (cols[col] || d1[id1] || d2[id2])
                continue;
            // our choice
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            helper(row + 1, cols, d1, d2, n);
            // revert the choice
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
