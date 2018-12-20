/**
 * time: O(n)
 * space: O(1)
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0)
            return res;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }
        return res;
    }
}
