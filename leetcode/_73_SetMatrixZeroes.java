public class _73_SetMatrixZeroes {
    /**
     * time: O(m * n)
     * space: O(1)
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        // get the projection of first row and first column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0)
                        row = true;
                    if (j == 0)
                        col = true;
                }
            }
        }
        // set row to zeroes
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // set column to zeroes
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // corner case for 0 in first row
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        // corner case for 0 in first column
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
