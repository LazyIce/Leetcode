public class _188_BestTimetoBuyandSellStockIV {
    /**
     * Dynamic Programming
     * time: O(k*n)
     * space: O(k*n)
     *
     * dp[k, i] represents the max profit up until prices[i] using at most k transactions.
     * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     * dp[0, i] = 0; 0 transactions makes 0 profit
     * dp[k, 0] = 0; if there is only one price data point you can't make any transaction.
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0)
            return 0;

        // corner case: we can make maximum transactions as we like
        if (k >= prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        // we can have no transaction, so k + 1 here
        int dp[][] = new int[k + 1][prices.length];
        for(int i = 1; i <= k; i++) {
            int min = prices[0];
            for(int j = 1; j < prices.length; j++) {
                min = Math.min(min, prices[j - 1] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[k][prices.length - 1];
    }
}
