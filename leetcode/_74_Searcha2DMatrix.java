public class _74_Searcha2DMatrix {
    /**
     * Binary Search
     * time: O(log(m*n))
     * space: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int low = 0, high = matrix.length * matrix[0].length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int val = matrix[mid / matrix[0].length][mid %  matrix[0].length];
            if (val == target)
                return true;
            else if (val < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }
}
