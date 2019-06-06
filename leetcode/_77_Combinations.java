import java.util.List;
import java.util.ArrayList;

public class _77_Combinations {
    /**
     * Backtracking
     * time: O(C(n, k))
     * space: O(n)
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        helper(res, n, k, new ArrayList<>(), 1);
        return res;
    }

    public void helper(List<List<Integer>> res, int n, int k, List<Integer> list, int start) {
        // our goal
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
