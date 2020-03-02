public class _689_MaximumSumofThreeNonOverlappingSubarrays {
    /**
     * DP
     * time: O(n)
     * space: O(n)
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        if (nums == null || k <= 0 || nums.length < 3 * k) {
            return res;
        }
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        int[][] dp = new int[4][n + 1];
        int[][] pos = new int[4][n + 1];

        for (int i = 1; i <= 3; i++) {
            // Notice, here position is off by 1
            for (int j = k * i; j <= n; j++) {
                int curSum = sums[j] - sums[j - k] + dp[i - 1][j - k];
                if (curSum > dp[i][j - 1]) {
                    dp[i][j] = curSum;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
            }
        }
        int index = n;
        for (int i = 2; i >= 0; i--) {
            res[i] = pos[i + 1][index];
            index = res[i];
        }
        return res;
    }
}
