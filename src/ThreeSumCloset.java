/**
 * time: O(n^2)
 * space: O(1)
 */

import java.util.Arrays;
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int low = i+1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum < target)
                    low++;
                else
                    high--;
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }
}
