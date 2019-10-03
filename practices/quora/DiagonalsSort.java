import java.util.Arrays;

public class DiagonalsSort {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {8, 4, 1, 3},
                {4, 4, 1, 6},
                {4, 8, 9, 7},
                {3, 5, 2, 2}
        };

        for (int k = 0; k < matrix.length - 1; k++) {
            for (int i = 0; i < matrix.length; i++) {
                while (i > 0 && matrix[i - 1][i - 1] > matrix[i][i]) {
                    int temp = matrix[i][i];
                    matrix[i][i] = matrix[i - 1][i - 1];
                    matrix[i - 1][i - 1] = temp;
                    i--;
                }
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
