import java.util.Arrays;
import java.util.Comparator;

public class CokeVender {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{100, 120}, {200, 240}, {400, 410}};
        int[] target = new int[] {310, 360};
        System.out.println(getCoke(intervals, target));
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
        Arrays.sort(ranges, new Comparator<int[]>(){
            public int compare(int[] range1, int[] range2) {
                return Integer.compare(range2[0], range1[0]);
            }
        });

        for(int i = 0; i < targetLow; i++) {
            for(int j = rangeLen - 1; j >= 0; j--) {
                int[] range = ranges[j];
                if(i - range[0] < 0)
                    break; // 因为ranges内， range[0]经过上述排序递减
                if(dp[i - range[0]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - range[0]] + range[1]);
                }
            }
            // 如果dp[i]不为Integer.MAX_VALUE, 说明通过按键组合，能得到 一个range以i为左边界，dp[i]为可能值最小的右边界
            // 如果 range[0] + i >= targetLow, 说明再次按键得到的范围， 左边界在[targetLow, targetHigh]内，此时判断右边界是否也在[targetLow, targetHigh]内
            if(dp[i] != Integer.MAX_VALUE && i + ranges[0][0] >= targetLow) {
                for(int[] range : ranges) {
                    // 因为ranges内， range[0]经过上述排序递减
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
