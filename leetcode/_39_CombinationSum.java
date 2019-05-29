import java.util.List;
import java.util.ArrayList;

public class _39_CombinationSum {
    /**
     * time: O(2^n)
     * space: O(n) or O(n^2)
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        helper(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }

    // Backtracking
    public void helper(List<List<Integer>> res, int[] candidates, int target, List<Integer> ans, int index) {
        // our choices
        if (target == 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        // our constraints
        if (target < 0)
            return;
        // our choices
        for (int i = index; i < candidates.length; i++) {
            ans.add(candidates[i]);
            helper(res, candidates, target - candidates[i], ans, i);
            ans.remove(ans.size() - 1);
        }
    }
}
