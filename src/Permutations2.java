/**
 * time:
 * space:
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
