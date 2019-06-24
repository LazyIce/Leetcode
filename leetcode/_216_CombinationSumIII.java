import java.util.List;
import java.util.ArrayList;

public class _216_CombinationSumIII {
    /**
     * Backtracking
     * time: O(2^n)
     * space: O(n)
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combination(res, new ArrayList<Integer>(), k, 1, n);
        return res;
    }

    private void combination(List<List<Integer>> res, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> list = new ArrayList<Integer>(comb);
            res.add(list);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(res, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
