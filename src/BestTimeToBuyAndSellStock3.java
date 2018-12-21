/**
 * time: O(n)
 * space: O(1)
 */
public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int min = Integer.MAX_VALUE;
        int localMax = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                localMax = Math.max(localMax, prices[i] - min);
            }
            left[i] = localMax;
        }

        int max = Integer.MIN_VALUE;
        localMax = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else {
                localMax = Math.max(localMax, max - prices[i]);
            }
            right[i] = localMax;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
