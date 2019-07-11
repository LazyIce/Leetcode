public class _322_CoinChange {
    /**
     * Dynamic Programming
     * time: O(n*amount)
     * space: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;
        // dp[i]: the min #coins to reach the amount i
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] >= 0)
                    min = Math.min(dp[i - coins[j]] + 1, min);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }

        return dp[amount];
    }
}
