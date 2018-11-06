public class CardGame {
    public static void main(String[] args) {
        int[] costs = new int[]{4,  5, 1};
        int[] damages = new int[]{1, 2, 3};
        System.out.println(Solution(5, 3, costs, damages));
    }

    public static boolean Solution (int total_money, int total_damage, int[] costs, int[] damages) {
        int card = costs.length;
        int[][] dp = new int[card+1][total_money+1];
        for (int i = 0; i <= card; i++) {
            for (int j = 0; j <= total_money; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j < costs[i - 1])
                        dp[i][j] = dp[i - 1][j];
                    else {
                        dp[i][j] = Math.max(dp[i-1][j - costs[i - 1]] + damages[i - 1], dp[i-1][j]);
                    }
                }
            }
        }
        if (dp[card][total_money] >= total_damage)
            return true;
        else
            return false;
    }
}
