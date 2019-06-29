import java.util.List;
import java.util.ArrayList;

public class _254_FactorCombinations {
    /**
     * Backtracking
     * time: TBD
     * space: O(logn)
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, n, new ArrayList<>(), 2);
        return res;
    }

    public void helper(List<List<Integer>> res, int n, List<Integer> list, int start) {
        // our goal
        if (n == 1) {
            if (list.size() > 1) { // !important
                res.add(new ArrayList<>(list));
                return;
            }
        }
        // our choice
        for (int i = start; i <= n; i++) {
            // our constraints
            if (n % i == 0) {
                list.add(i);
                helper(res, n / i, list, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
