public class _329_LongestIncreasingPathinaMatrix {
    /**
     * DFS + Memo
     * time: O(m*n)
     * space: O(m*n)
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int res = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int max = dfs(matrix, cache, Integer.MIN_VALUE, i, j);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int[][] cache, int min, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] <= min) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int a = dfs(matrix, cache,  min, i - 1, j) + 1;
        int b = dfs(matrix, cache,  min, i + 1, j) + 1;
        int c = dfs(matrix, cache, min, i, j - 1) + 1;
        int d = dfs(matrix, cache, min, i, j + 1) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
}
