import java.util.*;

public class BestSquares {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 4},
                {6, 5, 5},
                {3, 2, 1}
        };
        int k = 2;
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        int max = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {
                int sum = 0;
                Set<Integer> set = new HashSet<>();
                for (int s = 0; s < k; s++) {
                    for (int t = 0; t < k; t++) {
                        sum += matrix[i + s][j + t];
                        set.add(matrix[i + s][j + t]);
                    }
                }
                max = Math.max(max, sum);
                if (map.containsKey(sum)) {
                    Set<Integer> cur = map.get(sum);
                    cur.addAll(set);
                    map.put(sum, cur);
                } else {
                    map.put(sum, set);
                }
            }
        }

        for (Integer num : map.get(max)) {
            res += num;
        }

        System.out.println(res);
    }
}
