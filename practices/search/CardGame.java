public class CardGame {
    public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        }

        if (values.length < 3){
            return true;
        }

        if (values == null || values.length == 0) return false;

        int[] dp = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            if (i == values.length - 1) {
                dp[i] = values[i];
            } else if (i == values.length - 2) {
                dp[i] = values[i] + values[i + 1];
            } else {
                dp[i] = Math.max(values[i] - dp[i + 1], values[i] + values[i + 1] - dp[i + 2]);
            }
        }

        return dp[0] >= 0;
    }
}
