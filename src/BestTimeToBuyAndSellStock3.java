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
}
