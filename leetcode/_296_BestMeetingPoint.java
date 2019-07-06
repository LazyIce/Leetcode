import java.util.List;
import java.util.ArrayList;

public class _296_BestMeetingPoint {
    /**
     * time: O(m*n)
     * space: O(n)
     * consider the median of all points
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        // keep the row index
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }
        // keep the column index
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }

        return min(I) + min(J);
    }

    public int min(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
