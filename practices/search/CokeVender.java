import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class CokeVender {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{100, 120}, {200, 240}, {400, 410}};
        int[] target = new int[] {310, 360};
        System.out.println(dfsMemo(intervals, target));
    }

    public static boolean dfsMemo(int[][] sodas, int[] target) {
        return dfs(sodas, new HashMap<>(), 0, 0, target[0], target[1]);
    }

    public static boolean dfs(int[][] sodas, Map<String, Boolean> memo, int lower, int upper, int targetLower, int targetUpper) {
        String query = lower + "-" + upper;
        if (memo.containsKey(query)) {
            return memo.get(query);
        }
        if (lower >= targetLower && upper <= targetUpper) {
            return true;
        }
        if (upper > targetUpper) {
            return false;
        }
        for (int[] soda : sodas) {
            if (dfs(sodas, memo, lower + soda[0], upper + soda[1], targetLower, targetUpper)) {
                memo.put(query, true);
                return true;
            }
        }

        memo.put(query, false);
        return false;
    }

    public static boolean getCoke(int[][] sodas, int[] target) {

        int m = target[0];
        int n = target[1];
        boolean[][] dp = new boolean[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int[] soda : sodas) {
                    if (i <= soda[0] && j >= soda[1]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int[] soda : sodas) {
                    int preL = i - soda[0];
                    int preR = j - soda[1];
                    if (preL >= 0 && preR >= 0 && dp[preL][preR]) {
                        dp[i][j] = true;
                        break;
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static boolean ChichenButtonMakeRange(int[][] ranges, int targetLow, int targetHigh) {
        int rangeLen = ranges.length;
        int[] dp = new int[targetLow];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(ranges, (a, b) -> b[0] - a[0]);

        for(int i = 0; i < targetLow; i++) {
            for(int j = rangeLen - 1; j >= 0; j--) {
                int[] range = ranges[j];
                if(i - range[0] < 0)
                    break;
                if(dp[i - range[0]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - range[0]] + range[1]);
                }
            }

            if(dp[i] != Integer.MAX_VALUE && i + ranges[0][0] >= targetLow) {
                for(int[] range : ranges) {
                    if(range[0] + i < targetLow)
                        break;
                    if(range[1] + dp[i] <= targetHigh) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
