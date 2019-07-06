public class _304_RangeSumQuery2DImmutable {
    /**
     * Dynamic Programming
     */
    private int[][] sums;

    public _304_RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int minI = Math.min(row1, row2);
        int maxI = Math.max(row1, row2);
        int minJ = Math.min(col1, col2);
        int maxJ = Math.max(col1, col2);
        return sums[maxI + 1][maxJ + 1] - sums[maxI + 1][minJ] - sums[minI][maxJ + 1] + sums[minI][minJ];
    }
}
