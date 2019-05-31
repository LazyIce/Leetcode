import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _47_PermutationsII {
    /**
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);   // sort for duplicates
        helper1(res, nums, new ArrayList<>(), new boolean[nums.length]);

        return res;
    }

    // Backtracking
    public void helper1(List<List<Integer>> res, int[] nums, List<Integer> list, boolean[] used) {
        // our goals
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // our choices
        for (int i = 0; i < nums.length; i++) {
            // our constraint
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            helper1(res, nums, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * time: O(n!)
     * space: O(n)
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);   // sort for duplicates
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
            // our constraint
            if (isUsed(nums, start, i))
                continue;
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

    public boolean isUsed(int[] nums, int i, int j) {
        for (int k = i; k <j; k++) {
            if (nums[j] == nums[k])
                return true;
        }
        return false;
    }
}
