import java.util.Arrays;

public class RotateMatrixAmongDiagnals {
    public static void main(String[] args) {
        /**
         * [[1,16,11,6,5],
         * [22,7,12,9,2],
         * [23,18,13,8,3],
         * [24,17,14,19,4],
         * [21,10,15,20,25]]
         */
        int[][] matrix = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17 ,18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (i == j || i + j + 1 == matrix.length) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                if (i == j || i + j + 1 == matrix.length) {
                    continue;
                }
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
