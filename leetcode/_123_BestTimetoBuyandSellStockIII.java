public class _123_BestTimetoBuyandSellStockIII {
    /**
     * time: O(n)
     * space: O(1)
     */
    public int maxProfit1(int[] prices) {
        int sell1 = 0;
        int sell2 = 0;
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;

        for (int price : prices) {
            sell2 = Math.max(sell2, buy2 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell1 = Math.max(sell1, buy1 + price);
            buy1 = Math.max(buy1, -price);
        }

        return sell2;
    }

    /**
     * general solution
     * DP transition: dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     * For k transactions, on i-th day
     * time: O(n^k)
     * space: O(k*n)
     */
    public int maxProfit2(int[] prices) {
        if(prices.length == 0)
            return 0;
        int trans = 2;
        int dp[][] = new int[trans + 1][prices.length];

        for(int i = 1; i <= trans; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j < prices.length; j++) {
                min = Math.min(min, prices[j - 1] - dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] - min);
            }
        }
        return dp[trans][prices.length - 1];
    }
}
