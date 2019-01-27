/**
 * time: O(n^2)
 * space: O(n)
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i + 1] = Math.max(dp[j + 1] + 1, dp[i + 1]);
                }
            }
        }
        int len = 0;
        for (int i = 0; i<=nums.length; i++) {
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
