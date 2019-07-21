import java.util.Map;
import java.util.HashMap;

public class _377_CombinationSumIV {
    /**
     * time: O(2^n)
     * space: O(n)
     */
    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }

    private int helper(int[] nums, int target, Map<Integer, Integer> map) {
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }
        map.put(target, res);
        return res;
    }
}
