import java.util.Map;
import java.util.HashMap;

public class _325_MaximumSizeSubarraySumEqualsk {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = 0;
        // key is the sum of nums[0] to nums[i], value is the index i
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}
