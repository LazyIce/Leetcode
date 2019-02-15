import java.util.HashMap;
import java.util.Map;

public class ConnectedComponents {
    public static void main(String[] args) {
        String[][] matrix = new String[][] {{"red", "green", "blue"},
                                                         {"green", "green", "green"},
                                                         {"blue", "green", "red"}};
        Map<String, Integer> res = getColors(matrix);
        for (Map.Entry<String, Integer> item : res.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public static Map<String, Integer> getColors(String[][] matrix) {
        Map<String, Integer> res = new HashMap<>();
        if (matrix == null || matrix.length == 0)
            return res;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == " ")
                    continue;
                res.put(matrix[i][j], res.getOrDefault(matrix[i][j], 0) + 1);
                dfs(matrix, i, j, matrix[i][j]);
            }
        }
        return res;
    }

    public static void dfs(String[][] matrix, int i, int j, String color) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != color)
            return;
        if (matrix[i][j] == color)
            matrix[i][j] = " ";
        dfs(matrix, i - 1, j, color);
        dfs(matrix, i + 1, j, color);
        dfs(matrix, i, j - 1, color);
        dfs(matrix, i, j + 1, color);
    }
}
