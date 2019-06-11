public class _121_BestTimetoBuyandSellStock {
    /**
     * Dynamic programming
     * time: O(n)
     * space: O(1)
     */
    public int maxProfit1(int[] prices) {
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }

        return sell;
    }

    /**
     * Greedy
     * time: O(n)
     * space: O(1)
     */
    public int maxProfit2(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            res = Math.max(prices[i] - min, res);
        }

        return res;
    }

    /**
     * Kadane's Algorithm: max subarray problem
     * Dynamic programming
     * time: O(n)
     * space: O(1)
     */
    public int maxProfit3(int[] prices) {
        int maxCur = 0;   // current maximum value
        int maxSoFar = 0;   // maximum value found so far
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
