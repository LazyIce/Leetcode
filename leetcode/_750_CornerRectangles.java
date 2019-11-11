public class _750_CornerRectangles {
    /**
     * time: O(m^2*n)
     * space: O(1)
     */
    public int countCornerRectangles1(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    res += counter * (counter - 1) / 2;
                }
            }
        }
        return res;
    }
}
