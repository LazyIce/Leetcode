import java.util.List;
import java.util.ArrayList;

public class _46_Permutations {
    /**
     * time: O(n! * n)
     * space: O(n)
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        helper1(res, nums, new ArrayList<>());

        return res;
    }

    // Backtracking
    public void helper1(List<List<Integer>> res, int[] nums, List<Integer> list) {
        // our goals
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // our choices
        for (int i = 0; i < nums.length; i++) {
            // our constraint
            if (list.contains(nums[i]))   // O(n)
                continue;
            list.add(nums[i]);
            helper1(res, nums, list);
            list.remove(list.size() - 1);
        }
    }

    /**
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        helper2(res, nums, 0);

        return res;
    }

    // Backtracking
    public void helper2(List<List<Integer>> res, int[] nums, int start) {
        // our goals
        if (start == nums.length) {
            List list = new ArrayList<>();
            for (int num : nums)
                list.add(num);
            res.add(list);
            return;
        }
        // our choices
        for (int i = start; i < nums.length; i++) {
            // constraints: each recursion, start + 1 is the base.
            swap(nums, start, i);
            helper2(res, nums, start + 1);
            swap(nums, start, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
