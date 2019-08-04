import java.util.Map;
import java.util.HashMap;

public class _560_SubarraySumEqualsK {
    /**
     * time: O(n)
     * space: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
