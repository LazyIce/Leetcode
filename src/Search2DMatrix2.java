/**
 * time: O(m+n)
 * space: O(1)
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0){
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                col--;
            } else{
                row++;
            }
        }
        return false;
    }
}
