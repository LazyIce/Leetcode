import java.util.Arrays;

public class _16_ThreeSumClosest {
    /**
     * time: O(n^2)
     * space: O(1)
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;

        int res = nums[0] + nums[1] + nums[nums.length - 1];

        // sort before two pointers
        Arrays.sort(nums);
        // two pointers
        for (int i = 0; i < nums.length - 2; i++) {
            // handle the first number duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // Two pointers
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high] + nums[i];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
                if (sum < target)
                    low++;
                else if (sum > target)
                    high--;
            }
        }

        return res;
    }
}
