/**
 * time: O(logm + logn)
 * space: O(1)
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int start1 = 0;
        int end1 = m - 1;
        while (start1 + 1 < end1) {
            int mid = (end1 - start1) / 2 + start1;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start1 = mid;
            } else {
                end1 = mid;
            }
        }
        if (target < matrix[start1][0])
            return false;
        else if (target > matrix[end1][0])
            row = end1;
        else if (target == matrix[start1][0] || target == matrix[end1][0])
            return true;
        else
            row = start1;
        int start2 = 0;
        int end2 = n - 1;
        while (start2 <= end2) {
            int mid = (end2 - start2) / 2 + start2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start2 = mid + 1;
            } else {
                end2 = mid - 1;
            }
        }
        return false;
    }
}
