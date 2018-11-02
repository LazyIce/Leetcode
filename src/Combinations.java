/**
 * time: O(n!)
 * space:
 */
import  java.util.List;
import java.util.ArrayList;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <=n; i++) {
            list.add(i);
            helper(res, list, n, k, i+1);
            list.remove(list.size() - 1);
        }
    }
}
