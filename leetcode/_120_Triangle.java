import java.util.List;
import java.util.ArrayList;

public class _120_Triangle {
    /**
     * Dynamic Programming
     * time: O(n^2)
     * space: O(n)
     *
     2 0 0 0
     3 4 0 0
     6 5 7 0
     4 1 8 3
     From bottom to top
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
