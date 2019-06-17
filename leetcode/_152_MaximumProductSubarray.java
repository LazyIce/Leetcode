public class _152_MaximumProductSubarray {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        // keep the cur max
        // consider the negative number, we should keep the cur min
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(max, res);
        }

        return res;
    }
}
