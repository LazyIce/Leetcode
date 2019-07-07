public class _309_BestTimetoBuyandSellStockwithCooldown {
    /**
     * Dynamic Programming
     * time: O(n)
     * space: O(1)
     */
    public int maxProfit(int[] prices) {
        int sold = 0;
        int rest = 0;
        int hold = Integer.MIN_VALUE;
        for (int price : prices) {
            int prev_sold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prev_sold);
        }
        return Math.max(rest, sold);
    }
}
