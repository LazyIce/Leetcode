public class _55_JumpGame {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;

        int nextMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > nextMax)
                return false;
            nextMax = Math.max(nextMax, nums[i] + i);
        }

        return true;
    }
}
