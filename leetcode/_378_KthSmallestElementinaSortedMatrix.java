public class _378_KthSmallestElementinaSortedMatrix {
    /**
     * Binary Search
     * time: O(n*log(max-min))
     * space: O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix.length - 1];
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int count = getLessEqual(matrix, mid);
            if (count < k)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return start;
    }

    public int getLessEqual(int[][] matrix, int val) {
        int res = 0;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] > val)
                i--;
            else {
                res += i + 1;
                j++;
            }
        }

        return res;
    }
}
