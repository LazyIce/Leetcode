import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _90_SubsetsII {
    /**
     * Backtracking
     * time: O(2^n)
     * space: O(n)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    public void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int start) {
        // our goal
        res.add(new ArrayList<>(list));
        // our constraint
        if (start == nums.length)
            return;
        for (int i = start; i < nums.length; i++) {
            // our constraint
            if (i > start && nums[i] == nums[i - 1])
                continue;
            // our choice
            list.add(nums[i]);
            helper(res, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
