public class _209_MinimumSizeSubarraySum {
    /**
     * Sliding Window
     * time: O(n)
     * space: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int left = 0, right = 0, min = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
