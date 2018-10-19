/**
* time: O(n)
* space: O(n)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2)
            return true;
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        if (dp[0] >= nums.length-1)
            return true;
        for (int i = 1; i < nums.length - 1; i++) {
            if (dp[i-1] < i)
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] >= (nums[i] + i) ? dp[i-1] : (nums[i] + i);
            if (dp[i] >= nums.length-1)
                return true;
        }
        return false;
    }
}
