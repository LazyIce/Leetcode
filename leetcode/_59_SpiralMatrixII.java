public class _59_SpiralMatrixII {
    /**
     * time: O(n^2)
     * space: O(1)
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = num;
                num++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = num;
                num++;
            }
            colEnd--;
            // since the matrix are n*n, we don't need to check duplicates like q54
            for (int i = colEnd; i >= colBegin; i--) {
                res[rowEnd][i] = num;
                num++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowBegin; i--) {
                res[i][colBegin] = num;
                num++;
            }
            colBegin++;
        }
        return res;
    }
}
