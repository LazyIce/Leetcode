public class MaxSteel {
    public static void main(String[] args) {
        int[] prices = new int[] {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(getMaxMoney2(prices, 4));
    }

    public static int getMaxMoney1(int[] prices, int len) {
        if (len == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, getMaxMoney1(prices, len - i - 1) + prices[i]);
        }

        return res;
    }

    public static int getMaxMoney2(int[] prices, int len) {
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            int res = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                res = Math.max(res, prices[j - 1] + dp[i - j]);
            }
            dp[i] = res;
        }

        return dp[len];
    }
}
