public class _238_ProductofArrayExceptSelf {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[nums.length];
        int[] res = new int[nums.length];
        res[0] = 1;
        // 1 2 3 4
        // 1 1 2 6
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // right: 1 4 12 24
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }
}
