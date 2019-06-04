public class _70_ClimbingStairs {
    /**
     * Dynamic programming
     * time: O(n)
     * space: O(n)
     */
    public int climbStairs1(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1]; // dp[n]: #distinct ways to take n steps
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * time: O(n)
     * space: O(1)
     */
    public int climbStairs2(int n) {
        if (n <= 1) return 1;
        int oneStep = 1, twoStep = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }

    /**
     * time: O(2^n)
     * space: O(1)
     */
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs3(n - 1) + climbStairs3(n - 2);
        }
    }
}
