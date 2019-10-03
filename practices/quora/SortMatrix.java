import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {16, 15, 13, 10},
                {14, 12, 9, 6},
                {11, 8, 5, 3},
                {7, 4, 2, 1}
        };
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue()? a.getKey() - b.getKey() : a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            pq.offer(pair);
        }

        for (int i = 0; i < matrix.length * 2 - 1; i++) {
            int j = (i < matrix.length) ? matrix.length - 1 : matrix.length * 2 - i - 2;
            for (int k = j; k >= j - i && k >= 0; k--) {
                matrix[matrix.length * 2 - 2 - i - k][k] = pq.poll().getKey();
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
