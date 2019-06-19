import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class _169_MajorityElement {
    /**
     * time: O(nlogn)
     * space: O(1)
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int max = 0;
        for (int num : nums) {
            if (map.getOrDefault(num, 0) >= max) {
                res = num;
                max = map.getOrDefault(num, 0) + 1;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0)
                res = num;
            if (num != res)
                count--;
            else
                count++;
        }

        return res;
    }
}
