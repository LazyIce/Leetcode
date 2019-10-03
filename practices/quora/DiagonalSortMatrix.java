import java.util.Arrays;

public class DiagonalSortMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {8, 4, 1, 3},
                {4, 4, 1, 6},
                {4, 8, 9, 7},
                {3, 5, 2, 2}
        };

        for (int i = 0; i < matrix.length * 2 - 1; i++) {
            int diff = matrix.length - 1 - i;
            for (int j = 0; j <= matrix.length; j++) {
                int m = j;
                while (m - 1 >= 0) {
                    int row1 = m + diff;
                    int row2 = m - 1 + diff;
                    if (row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 <= matrix.length) {
                        if (matrix[row1][m] < matrix[row2][m - 1]) {
                            int temp = matrix[row1][m];
                            matrix[row1][m] = matrix[row2][m - 1];
                            matrix[row2][m - 1] = temp;
                        }
                    }
                    m--;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
