public class _311_SparseMatrixMultiplication {
    /**
     * time: O(m*n*nB)
     * space: O(m*nB)
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length;
        int nB = B[0].length;
        int[][] res = new int[m][nB];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < nB; k++) {
                        if (B[j][k] != 0)
                            res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return res;
    }
}
