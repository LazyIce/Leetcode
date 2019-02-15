public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            res = Math.max(res, sum);
        }
        return res;
    }
}
