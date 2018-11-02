/**
 * time: O(n!)
 * space:  O(2^n)
 */
import java.util.List;
import java.util.ArrayList;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>(new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
            helper(res, new ArrayList<Integer>(), nums, i, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, k, i+1);
            list.remove(list.size() - 1);
        }
    }
}
