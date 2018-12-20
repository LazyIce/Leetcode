/**
 * time: O(n)
 * space: O(1)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0)
            return res;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > res)
                res = prices[i] - min;
            if (prices[i] < min)
                min = prices[i];
        }
        return res;
    }
}
