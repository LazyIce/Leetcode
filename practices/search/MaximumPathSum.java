import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{5, 15, 20}, {10, 15, 5}, {30, 5, 5}};
        System.out.println(getMaxSum1(grid));
        System.out.println(getMaxSum2(grid));
        for (List<Integer> step : getPath(grid)) {
            System.out.println(Arrays.toString(step.toArray(new Integer[0])));
        }
    }

    public static int getMaxSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    public static int getMaxSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]);
                dp[j] += grid[i][j - 1];
            }
        }

        return dp[n];
    }

    public static List<List<Integer>> getPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int j = 1; j < n; j++) {
            grid[0][j] = -(Math.abs(grid[0][j - 1]) + grid[0][j]);
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int top = Math.abs(grid[i - 1][j]);
                int left = Math.abs(grid[i][j - 1]);
                if (top > left) {
                    grid[i][j] = top + grid[i][j];
                } else {
                    grid[i][j] = - (left + grid[i][j]);
                }
            }
        }

        List<List<Integer>> path = new ArrayList<>();
        int curI = m - 1;
        int curJ = n - 1;
        while (curI > 0 || curJ > 0) {
            path.add(Arrays.asList(curI, curJ));
            if (grid[curI][curJ] < 0) {
                curJ--;
            } else {
                curI--;
            }
        }
        path.add(Arrays.asList(0, 0));

        return path;
    }
}
