import java.util.LinkedList;
import java.util.Queue;

public class _1091_ShortestPathinBinaryMatrix {
    /**
     * time: O(n^2)
     * space: O(n^2)
     */
    int[][] dir = new int[][] {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == n - 1 && cur[1] == n - 1) {
                    res += 1;
                    return res;
                }

                for (int j = 0; j < 8; j++) {
                    int newX = cur[0] + dir[j][0];
                    int newY = cur[1] + dir[j][1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
