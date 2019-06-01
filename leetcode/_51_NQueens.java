import java.util.List;
import java.util.ArrayList;

public class _51_NQueens {
    /**
     * time: O(n^n) Not sure
     * space: O(n^2)
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0)
            return res;
        helper(res, new int[n], 0);
        return res;
    }

    // Backtracking
    public void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
            return;
        }

        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;   // our choice
            if (isValid(queens, pos)) {   // our constraints
                helper(res, queens, pos + 1);
            }
        }
    }

    public boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) {
                return false;
            } else if (Math.abs(queens[pos] - queens[i]) == Math.abs(i - pos)) {
                return false;
            }
        }
        return true;
    }

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
